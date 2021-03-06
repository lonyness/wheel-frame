package com.frame.wheel.wheelsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 权限-角色关联表
 * @author lonyness
 * @Date 2020年6月25日
 */
@TableName(value = "sys_role_permissions")
public class SysRolePermissions implements Serializable {

  //指定主键生成策略使用雪花算法（默认策略）
  @TableId(value = "id",type = IdType.ASSIGN_ID)
  private String id;
  private String roleId;
  private String permissionsId;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }


  public String getPermissionsId() {
    return permissionsId;
  }

  public void setPermissionsId(String permissionsId) {
    this.permissionsId = permissionsId;
  }

}
