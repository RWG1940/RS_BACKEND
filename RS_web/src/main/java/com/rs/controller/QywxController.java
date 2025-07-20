package com.rs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rs.domain.Emp;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.QywxService;
import com.rs.service.impl.EmpServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/wx")
@Api(tags = "企业微信接口")
public class QywxController {

    @Autowired
    private QywxService qywxService;
    @Autowired
    private EmpServiceImpl empServiceImpl;

    @GetMapping("/sync")
    @PreAuthorize("hasAuthority('admin')")
    public ResultResponse syncQywxData() {
        qywxService.syncQywxData();
        return ResultResponse.success("ok");
    }

    @GetMapping("/reg")
    @PreAuthorize("hasAuthority('admin')")
    public ResultResponse regQywxData() {
        qywxService.regQywxData();
        return ResultResponse.success("ok");
    }
    @GetMapping("/callback")
    @ApiOperation("企业微信扫码登录回调")
    public void wechatCallback(@RequestParam("code") String code,
                               @RequestParam(value = "state", required = false) String state,
                               @RequestParam("appid") String appid,
                               HttpServletResponse response) throws IOException {
        // 通过code值从已同步企微用户数据库表中匹配出userId
        String userId = qywxService.getUserIdByCode(code);
        // 通过userId从emp表中匹配出用户
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("e_qywx_id", userId);
        Emp emp = empServiceImpl.getOne(queryWrapper);
        if (emp != null) {
            String token = qywxService.generateTokenForEmp(emp);
            System.out.println(token);
            if (state.equals("zhuomian")){
                response.sendRedirect("http://localhost:8888/#/work-sheet?token=" + token);
            }else {
                response.sendRedirect("http://192.168.24.6:8888/login?token=" + token);
            }
        } else {
            response.sendRedirect("http://192.168.24.6:8888/login");
        }
    }
}

