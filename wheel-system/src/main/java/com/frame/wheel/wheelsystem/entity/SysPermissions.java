package com.frame.wheel.wheelsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 用户权限表
 * @author lonyness
 * @Date 2020年6月25日
 */
@TableName(value = "sys_permissions")
public class SysPermissions {

  //指定主键生成策略使用雪花算法（默认策略）
  @TableId(value = "id",type = IdType.ASSIGN_ID)
  private String id;
  private String code;
  private String parentId;
  private String name;
  private long orderNo;
  private long status;
  private String tips;
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


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(long orderNo) {
    this.orderNo = orderNo;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getTips() {
    return tips;
  }

  public void setTips(String tips) {
    this.tips = tips;
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
