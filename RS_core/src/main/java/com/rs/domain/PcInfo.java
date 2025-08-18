package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 *
 * @TableName pc_info
 */
@TableName(value ="pc_info")
public class PcInfo {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private String ip;

    /**
     *
     */
    private String memoryTotal;

    /**
     *
     */
    private String memoryUsage;

    /**
     *
     */
    private String diskList;

    /**
     *
     */
    private String empName;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

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
    public String getIp() {
        return ip;
    }

    /**
     *
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     *
     */
    public String getMemoryTotal() {
        return memoryTotal;
    }

    /**
     *
     */
    public void setMemoryTotal(String memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    /**
     *
     */
    public String getMemoryUsage() {
        return memoryUsage;
    }

    /**
     *
     */
    public void setMemoryUsage(String memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    /**
     *
     */
    public String getDiskList() {
        return diskList;
    }

    /**
     *
     */
    public void setDiskList(String diskList) {
        this.diskList = diskList;
    }

    /**
     *
     */
    public String getEmpName() {
        return empName;
    }

    /**
     *
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    /**
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        PcInfo other = (PcInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
                && (this.getMemoryTotal() == null ? other.getMemoryTotal() == null : this.getMemoryTotal().equals(other.getMemoryTotal()))
                && (this.getMemoryUsage() == null ? other.getMemoryUsage() == null : this.getMemoryUsage().equals(other.getMemoryUsage()))
                && (this.getDiskList() == null ? other.getDiskList() == null : this.getDiskList().equals(other.getDiskList()))
                && (this.getEmpName() == null ? other.getEmpName() == null : this.getEmpName().equals(other.getEmpName()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getMemoryTotal() == null) ? 0 : getMemoryTotal().hashCode());
        result = prime * result + ((getMemoryUsage() == null) ? 0 : getMemoryUsage().hashCode());
        result = prime * result + ((getDiskList() == null) ? 0 : getDiskList().hashCode());
        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ip=").append(ip);
        sb.append(", memoryTotal=").append(memoryTotal);
        sb.append(", memoryUsage=").append(memoryUsage);
        sb.append(", diskList=").append(diskList);
        sb.append(", empName=").append(empName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}