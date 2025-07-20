package com.rs.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/**
 *
 * @TableName qywx_user
 */
@TableName(value ="qywx_user")
@ApiModel(value = "企微用户实体")
public class QywxUser {
    /**
     *
     */
    @TableId
    private String userid;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Long departmentId;

    /**
     *
     */
    public String getUserid() {
        return userid;
    }

    /**
     *
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     *
     */
    public String getName() {
        return name;
    }

    /**
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     *
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        QywxUser other = (QywxUser) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", name=").append(name);
        sb.append(", departmentId=").append(departmentId);
        sb.append("]");
        return sb.toString();
    }
}