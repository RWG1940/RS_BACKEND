package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName emp_menu
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName(value ="emp_menu")
@ApiModel(value = "用户-权限关联实体")
public class EmpMenu implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer eId;

    /**
     * 
     */
    private Integer mId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public Integer geteId() {
        return eId;
    }

    /**
     * 
     */
    public void seteId(Integer eId) {
        this.eId = eId;
    }

    /**
     * 
     */
    public Integer getmId() {
        return mId;
    }

    /**
     * 
     */
    public void setmId(Integer mId) {
        this.mId = mId;
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
        EmpMenu other = (EmpMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.geteId() == null ? other.geteId() == null : this.geteId().equals(other.geteId()))
            && (this.getmId() == null ? other.getmId() == null : this.getmId().equals(other.getmId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((geteId() == null) ? 0 : geteId().hashCode());
        result = prime * result + ((getmId() == null) ? 0 : getmId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eId=").append(eId);
        sb.append(", mId=").append(mId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}