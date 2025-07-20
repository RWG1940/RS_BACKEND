package com.rs.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rs.domain.Emp;
import com.rs.domain.QywxDepartment;
import com.rs.domain.QywxUser;
import com.rs.domain.LoginUserDetail;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.mapper.EmpMapper;
import com.rs.mapper.QywxDepartmentMapper;
import com.rs.mapper.QywxUserMapper;
import com.rs.service.impl.UserDetailsServiceImpl;
import com.rs.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSON;

import java.util.*;

@Service
public class QywxService {

    @Autowired
    private QywxDepartmentMapper departmentMapper;

    @Autowired
    private QywxUserMapper userMapper;

    @Value("${wx.corp_id}")
    private String corpId;

    @Value("${wx.secret}")
    private String secret;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl  userDetailsService;


    /**
     * 获取 access_token
     */
    public String getAccessToken() {
        String tokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpId + "&corpsecret=" + secret;
        Map<String, Object> resp = restTemplate.getForObject(tokenUrl, Map.class);
        if (resp != null && "0".equals(resp.get("errcode").toString())) {
            return (String) resp.get("access_token");
        }
        throw new RuntimeException("获取 access_token 失败：" + resp);
    }

    /**
     * 同步部门和成员数据
     */
    @Transactional
    public void syncQywxData() {
        String token = getAccessToken();

        // 获取部门
        String deptUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + token;
        Map<String, Object> deptResp = restTemplate.getForObject(deptUrl, Map.class);
        List<Map<String, Object>> deptList = (List<Map<String, Object>>) deptResp.get("department");

        List<QywxDepartment> deptEntities = new ArrayList<>();
        for (Map<String, Object> dept : deptList) {
            QywxDepartment entity = new QywxDepartment();
            entity.setId(Long.parseLong(dept.get("id").toString()));
            entity.setName(dept.get("name").toString());
            entity.setParentId(Long.parseLong(dept.get("parentid").toString()));
            entity.setOrderNum(Integer.parseInt(dept.get("order").toString()));
            deptEntities.add(entity);
        }

        departmentMapper.delete(null); // 清空旧数据
        deptEntities.forEach(departmentMapper::insert);

        // 获取用户（遍历每个部门）
        userMapper.delete(null); // 清空用户表
        for (QywxDepartment dept : deptEntities) {
            String userUrl = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=" + token
                    + "&department_id=" + dept.getId() + "&fetch_child=0";
            Map<String, Object> userResp = restTemplate.getForObject(userUrl, Map.class);
            if (!"0".equals(String.valueOf(userResp.get("errcode")))) continue;

            List<Map<String, Object>> userList = (List<Map<String, Object>>) userResp.get("userlist");
            if (userList == null) continue;

            for (Map<String, Object> u : userList) {
                QywxUser user = new QywxUser();
                user.setUserid((String) u.get("userid"));
                user.setName((String) u.get("name"));
                List<Integer> deptIds = (List<Integer>) u.get("department");
                if (!deptIds.isEmpty()) {
                    user.setDepartmentId(Long.valueOf(deptIds.get(0)));
                }
                userMapper.insert(user);
            }
        }
    }

    @Transactional
    public void regQywxData() {
        // 获取所有企业微信用户
        List<QywxUser> qyUsers = userMapper.selectList(null);

        for (QywxUser qyUser : qyUsers) {
            // 检查是否已经存在对应职员
            Integer count = Math.toIntExact(empMapper.selectCount(
                    new QueryWrapper<Emp>()
                            .eq("e_qywx_id", qyUser.getUserid())
            ));

            // 如果不存在，插入新职员
            if (count == 0) {
                Emp emp = new Emp();
                emp.seteQywxId(qyUser.getUserid());
                emp.seteUsername(generateRandomUsername());
                emp.seteCreatetime(new Date());
                emp.seteUpdatetime(new Date());
                emp.setePassword(passwordEncoder.encode("123456"));
                // 你可以补充其他字段，比如从 qyUser 中取姓名等
                emp.seteName(qyUser.getName());
                emp.seteIsenabled(1);
                emp.seteDeptid(49);
                empMapper.insert(emp);
            }
        }
    }

    // 随机生成 8 位数字字符串
    private String generateRandomUsername() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public String getUserIdByCode(String code) {
        String token = getAccessToken();
        String url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=" + token + "&code=" + code;
        Map<String, Object> resp = restTemplate.getForObject(url, Map.class);
        if (resp != null && resp.get("UserId") != null) {
            return resp.get("UserId").toString();
        }
        throw new RuntimeException("获取企业微信用户ID失败：" + resp);
    }

    public Emp getEmpByQywxUserId(String userId) {
        return empMapper.selectOne(new QueryWrapper<Emp>().eq("e_qywx_id", userId));
    }

    // 你可以用JWT或Session等方式生成token
    public String generateTokenForEmp(Emp emp) {
        try {
            LoginUserDetail loginUserDetail = userDetailsService.loadUserByUsername(emp.geteUsername());
            String token =   JwtUtils.generateJwtFromJson(
                                JSON.toJSONString(loginUserDetail), (long) (60 * 60 * 24 * 7 * 1000));
            return token;
        } catch (Exception e) {
            throw new BizException(ExceptionEnum.UNAUTHORIZED, "用户名或密码错误");
        }



    }
}
