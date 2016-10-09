package com.tydic.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("article")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 所在分类
	 */
	private Short cid;
	/**
	 * 类型
	 */
	private Boolean type;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 点击率
	 */
	private Integer visitnums;
	/**
	 * 关键词
	 */
	private String keywords;
	/**
	 * 状态
	 */
	private Boolean status;
	/**
	 * 文章摘要
	 */
	private String summary;
	/**
	 * 短文
	 */
	private String thumbnail;
	/**
	 * 删除标记
	 */
	private Integer isdel;
	/**
	 * 发布者id
	 */
	private Short cuid;
	/**
	 * 创建时间
	 */
	private long ctime;
	/**
	 * uuid
	 */
	private String uuid;
	/**
	 * 修改时间
	 */
	private long utime;
}
