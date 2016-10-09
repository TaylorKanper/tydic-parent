package com.tydic.read.service;

import java.util.List;

import com.tydic.common.Response;
import com.tydic.model.Article;
import com.tydic.model.ArticleWithBLOBs;

public interface ArticleReadService {
	Response<List<Article>> select();
	Response<ArticleWithBLOBs> find(String id);
}
