package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
 * 
 * @TableName ym_domains
 */
@TableName(value ="ym_domains")
public class YmDomains {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String domain;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String registrar;

    /**
     * 
     */
    private Date expirationDate;

    /**
     * 
     */
    private String remainingDays;

    /**
     * 
     */
    private String dnsRecords;

    /**
     * 
     */
    private Date updatetime;

    /**
     * 
     */
    private Date createtime;

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
    public String getDomain() {
        return domain;
    }

    /**
     * 
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     */
    public String getRegistrar() {
        return registrar;
    }

    /**
     * 
     */
    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    /**
     * 
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * 
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * 
     */
    public String getRemainingDays() {
        return remainingDays;
    }

    /**
     * 
     */
    public void setRemainingDays(String remainingDays) {
        this.remainingDays = remainingDays;
    }

    /**
     * 
     */
    public String getDnsRecords() {
        return dnsRecords;
    }

    /**
     * 
     */
    public void setDnsRecords(String dnsRecords) {
        this.dnsRecords = dnsRecords;
    }

    /**
     * 
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        YmDomains other = (YmDomains) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDomain() == null ? other.getDomain() == null : this.getDomain().equals(other.getDomain()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRegistrar() == null ? other.getRegistrar() == null : this.getRegistrar().equals(other.getRegistrar()))
            && (this.getExpirationDate() == null ? other.getExpirationDate() == null : this.getExpirationDate().equals(other.getExpirationDate()))
            && (this.getRemainingDays() == null ? other.getRemainingDays() == null : this.getRemainingDays().equals(other.getRemainingDays()))
            && (this.getDnsRecords() == null ? other.getDnsRecords() == null : this.getDnsRecords().equals(other.getDnsRecords()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDomain() == null) ? 0 : getDomain().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRegistrar() == null) ? 0 : getRegistrar().hashCode());
        result = prime * result + ((getExpirationDate() == null) ? 0 : getExpirationDate().hashCode());
        result = prime * result + ((getRemainingDays() == null) ? 0 : getRemainingDays().hashCode());
        result = prime * result + ((getDnsRecords() == null) ? 0 : getDnsRecords().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", domain=").append(domain);
        sb.append(", status=").append(status);
        sb.append(", registrar=").append(registrar);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", remainingDays=").append(remainingDays);
        sb.append(", dnsRecords=").append(dnsRecords);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}