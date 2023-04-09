package com.example.ceserver.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
* 用户表
* @TableName tbl_sys_user
*/
@Builder
@Data
public class TblSysUser extends BaseEntity implements Serializable {

    /**
    * id
    */
    private String id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 用户名
    */
    private String username;
    /**
    * 性别
    */
    private String sex;
    /**
    * 头像URL
    */
    private String avatarUrl;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 电话
    */
    private String phone;
    /**
    * 备注
    */
    private String remarks;
    /**
    * 微信用户唯一标识
    */
    private String openId;
    /**
    * 微信用户唯一标识符
    */
    private String unionId;
    /**
    * 微信用户昵称
    */
    private String nickname;
    /**
    * 菜单列表
    */
    private String menuList;
}
