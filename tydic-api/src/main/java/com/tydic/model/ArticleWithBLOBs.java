package com.tydic.model;

import org.apache.ibatis.type.Alias;

@Alias("articlewithblobs")
public class ArticleWithBLOBs extends Article {
	private static final long serialVersionUID = 1L;
	/**
	 * 说明
	 */
	private String description;
	/**
	 * 内容
	 */
	private String content;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}
