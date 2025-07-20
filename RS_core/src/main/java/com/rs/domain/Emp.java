package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

@TableName("emp")
@ApiModel("员工实体")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String eId;

    private String eUsername;

    private String ePassword;

    private String eName;

    private Integer eGender;

    private Integer eAge;

    private String ePhone;

    private String eAvatarpath;

    private Date eCreatetime;

    private Date eUpdatetime;

    private Integer eIsenabled;

    private Integer eDeptid;

    private String eTelephone;

    private Date eBirthday;

    private String eDescription;

    private String eQywxId;

    // 无参构造器
    public Emp() {
    }

    // 单参数构造器
    public Emp(String eUsername) {
        this.eUsername = eUsername;
    }

    // 全参构造器
    public Emp(Integer id, String eId, String eUsername, String ePassword, String eName, Integer eGender,
               Integer eAge, String ePhone, String eAvatarpath, Date eCreatetime, Date eUpdatetime,
               Integer eIsenabled, Integer eDeptid, String eTelephone, Date eBirthday, String eDescription,
               String eQywxId) {
        this.id = id;
        this.eId = eId;
        this.eUsername = eUsername;
        this.ePassword = ePassword;
        this.eName = eName;
        this.eGender = eGender;
        this.eAge = eAge;
        this.ePhone = ePhone;
        this.eAvatarpath = eAvatarpath;
        this.eCreatetime = eCreatetime;
        this.eUpdatetime = eUpdatetime;
        this.eIsenabled = eIsenabled;
        this.eDeptid = eDeptid;
        this.eTelephone = eTelephone;
        this.eBirthday = eBirthday;
        this.eDescription = eDescription;
        this.eQywxId = eQywxId;
    }

    // 下面是 getter 和 setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteUsername() {
        return eUsername;
    }

    public void seteUsername(String eUsername) {
        this.eUsername = eUsername;
    }

    public String getePassword() {
        return ePassword;
    }

    public void setePassword(String ePassword) {
        this.ePassword = ePassword;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer geteGender() {
        return eGender;
    }

    public void seteGender(Integer eGender) {
        this.eGender = eGender;
    }

    public Integer geteAge() {
        return eAge;
    }

    public void seteAge(Integer eAge) {
        this.eAge = eAge;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public String geteAvatarpath() {
        return eAvatarpath;
    }

    public void seteAvatarpath(String eAvatarpath) {
        this.eAvatarpath = eAvatarpath;
    }

    public Date geteCreatetime() {
        return eCreatetime;
    }

    public void seteCreatetime(Date eCreatetime) {
        this.eCreatetime = eCreatetime;
    }

    public Date geteUpdatetime() {
        return eUpdatetime;
    }

    public void seteUpdatetime(Date eUpdatetime) {
        this.eUpdatetime = eUpdatetime;
    }

    public Integer geteIsenabled() {
        return eIsenabled;
    }

    public void seteIsenabled(Integer eIsenabled) {
        this.eIsenabled = eIsenabled;
    }

    public Integer geteDeptid() {
        return eDeptid;
    }

    public void seteDeptid(Integer eDeptid) {
        this.eDeptid = eDeptid;
    }

    public String geteTelephone() {
        return eTelephone;
    }

    public void seteTelephone(String eTelephone) {
        this.eTelephone = eTelephone;
    }

    public Date geteBirthday() {
        return eBirthday;
    }

    public void seteBirthday(Date eBirthday) {
        this.eBirthday = eBirthday;
    }

    public String geteDescription() {
        return eDescription;
    }

    public void seteDescription(String eDescription) {
        this.eDescription = eDescription;
    }

    public String geteQywxId() {
        return eQywxId;
    }

    public void seteQywxId(String eQywxId) {
        this.eQywxId = eQywxId;
    }
}
