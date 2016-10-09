package com.tydic.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("config")
public class Config implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private String id;
    /**
     * 类型
     */
    private String type;
    /**
     * 名字
     */
    private String name;
    /**
     * 代码
     */
    private String code;
    /**
     * 值
     */
    private String value;
    /**
     * 说明
     */
    private String description;
    /**
     * 删除标记
     */
    private Integer isdel;
    /**
     * 创建人id
     */
    private String cuid;
    /**
     * 创建时间
     */
    private Long ctime;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 修改时间
     */
    private Long utime;
}
