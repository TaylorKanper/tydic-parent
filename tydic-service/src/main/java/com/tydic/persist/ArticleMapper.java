package com.tydic.persist;

import java.util.List;

import com.tydic.model.Article;
import com.tydic.model.ArticleWithBLOBs;
public interface ArticleMapper{
	int deleteByPrimaryKey(String id);

	int insert(ArticleWithBLOBs record);

	int insertSelective(ArticleWithBLOBs record);

	ArticleWithBLOBs selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

	int updateByPrimaryKey(Article record);

	List<Article> selectAll();
}
