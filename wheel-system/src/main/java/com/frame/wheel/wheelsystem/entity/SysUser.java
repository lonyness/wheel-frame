package com.frame.wheel.wheelsystem.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 * @author lonyness
 * @Date 2020年6月15日
 */
@TableName(value = "sys_user")
public class SysUser implements Serializable {

  @TableId(value = "id",type = IdType.ASSIGN_ID)
  private long id;

  @TableField(value = "account")
  private String account;
  /**
   * 密码  注解含义为只允许序列化而不能进行反序列化，直观效果就是返回的数据没有该属性
   */
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
  private String salt;
  private long sex;
  private String email;
  private String phone;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date birthday;
  private long deptId;
  private String roleId;
  private long accountStatus;
  /**
   * 创建时间，格式为yyyy-MM-dd HH:mm
   * 仅在新增时进行数据插入
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 创建人
   * 仅在新增时进行数据插入
   */
  @TableField(fill = FieldFill.INSERT)
  private long createUser;
  /**
   * 修改时间，格式为yyyy-MM-dd HH:mm
   * 在修改和更新时进行数据插入
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
  @TableField(fill = FieldFill.INSERT)
  private Date updateTime;
  /**
   * 修改人
   * 在修改和更新时进行数据插入
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private long updateUser;
  /**
   * 乐观锁注释
   */
  @Version
  private long version;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }


  public long getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(long accountStatus) {
    this.accountStatus = accountStatus;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public long getCreateUser() {
    return createUser;
  }

  public void setCreateUser(long createUser) {
    this.createUser = createUser;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }


  public long getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(long updateUser) {
    this.updateUser = updateUser;
  }


  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

}
