package com.tydic.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer uid;
	/**
	 * 角色id
	 */
	private Integer oid;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 真实名称
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 查询代码
	 */
	private String findcode;
	/**
	 * 允许的系统
	 */
	private String allowsystem;
	/**
	 * 是否删除
	 */
	private Integer isdel;
	/**
	 * 创建该用户的创建者id
	 */
	private Integer cuid;
	/**
	 * 创建时间
	 */
	private Long ctime;
	/**
	 * uuid
	 */
	private Integer uuid;
	/**
	 * 修改时间
	 */
	private Long utime;

}
