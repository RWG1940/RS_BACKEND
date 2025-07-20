package com.rs.domain.dto;

import com.rs.domain.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @FileName: EmpRoleDTO
 * @Date: 2024/8/12:19:29
 * @Description: 用户信息和角色信息组合实体
 * @Author: RWG
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户信息和角色信息组合实体")
public class EmpRoleDeptDTO {
    @ApiModelProperty(value = "员工信息")
    private Emp emp;
    @ApiModelProperty(value = "角色信息")
    private Role role;
    @ApiModelProperty(value = "部门信息")
    private Dept dept;
    @ApiModelProperty(value = "在线状态")
    private int isOnline;
    @ApiModelProperty(value = "记住密码")
    private boolean rememberMe;
    @ApiModelProperty(value = "企微用户")
    private QywxUser qywxUser;
    @ApiModelProperty(value="企微部门")
    private QywxDepartment qywxDepartment;

    public EmpRoleDeptDTO(Emp e, Role roleByEmpId, Dept dept, int isOnline,QywxUser qu,QywxDepartment qd) {
        this.emp = e;
        this.role = roleByEmpId;
        this.dept = dept;
        this.isOnline = isOnline;
        this.qywxUser = qu;
        this.qywxDepartment = qd;
    }
}
