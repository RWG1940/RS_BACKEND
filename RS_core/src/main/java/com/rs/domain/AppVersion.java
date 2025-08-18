package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 * @TableName app_version
 */
@TableName(value ="app_version")
public class AppVersion {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Integer versionCode;

    /**
     * 
     */
    private String versionName;

    /**
     * 
     */
    private String updateTitle;

    /**
     * 
     */
    private String updateContent;

    /**
     * 
     */
    private String platform;

    /**
     * 
     */
    private String fileUrl;

    /**
     * 
     */
    private Long fileSize;

    /**
     * 
     */
    private Integer forceUpdate;

    /**
     * 
     */
    private Integer published;

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
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public Integer getVersionCode() {
        return versionCode;
    }

    /**
     * 
     */
    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    /**
     * 
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * 
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    /**
     * 
     */
    public String getUpdateTitle() {
        return updateTitle;
    }

    /**
     * 
     */
    public void setUpdateTitle(String updateTitle) {
        this.updateTitle = updateTitle;
    }

    /**
     * 
     */
    public String getUpdateContent() {
        return updateContent;
    }

    /**
     * 
     */
    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    /**
     * 
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * 
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * 
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 
     */
    public Integer getForceUpdate() {
        return forceUpdate;
    }

    /**
     * 
     */
    public void setForceUpdate(Integer forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    /**
     * 
     */
    public Integer getPublished() {
        return published;
    }

    /**
     * 
     */
    public void setPublished(Integer published) {
        this.published = published;
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
        AppVersion other = (AppVersion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVersionCode() == null ? other.getVersionCode() == null : this.getVersionCode().equals(other.getVersionCode()))
            && (this.getVersionName() == null ? other.getVersionName() == null : this.getVersionName().equals(other.getVersionName()))
            && (this.getUpdateTitle() == null ? other.getUpdateTitle() == null : this.getUpdateTitle().equals(other.getUpdateTitle()))
            && (this.getUpdateContent() == null ? other.getUpdateContent() == null : this.getUpdateContent().equals(other.getUpdateContent()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()))
            && (this.getForceUpdate() == null ? other.getForceUpdate() == null : this.getForceUpdate().equals(other.getForceUpdate()))
            && (this.getPublished() == null ? other.getPublished() == null : this.getPublished().equals(other.getPublished()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVersionCode() == null) ? 0 : getVersionCode().hashCode());
        result = prime * result + ((getVersionName() == null) ? 0 : getVersionName().hashCode());
        result = prime * result + ((getUpdateTitle() == null) ? 0 : getUpdateTitle().hashCode());
        result = prime * result + ((getUpdateContent() == null) ? 0 : getUpdateContent().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getForceUpdate() == null) ? 0 : getForceUpdate().hashCode());
        result = prime * result + ((getPublished() == null) ? 0 : getPublished().hashCode());
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
        sb.append(", versionCode=").append(versionCode);
        sb.append(", versionName=").append(versionName);
        sb.append(", updateTitle=").append(updateTitle);
        sb.append(", updateContent=").append(updateContent);
        sb.append(", platform=").append(platform);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", forceUpdate=").append(forceUpdate);
        sb.append(", published=").append(published);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}