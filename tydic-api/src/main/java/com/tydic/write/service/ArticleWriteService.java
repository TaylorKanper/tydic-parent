package com.tydic.write.service;

import com.tydic.common.Response;
import com.tydic.model.Article;
import com.tydic.model.ArticleWithBLOBs;

public interface ArticleWriteService {
	Response<Integer> delete(String id);

	Response<Integer> save(Article articleInfo);

	Response<Integer> add(ArticleWithBLOBs articleInfo);
}
