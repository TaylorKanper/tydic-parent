package com.tydic.read.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tydic.common.Response;
import com.tydic.model.Article;
import com.tydic.model.ArticleWithBLOBs;
import com.tydic.persist.ArticleMapper;
import com.tydic.read.service.ArticleReadService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleReadServiceImpl implements ArticleReadService {
	@Resource
	private ArticleMapper mapper;

	@Override
	public Response<List<Article>> select() {
		try {
			return Response.ok(mapper.selectAll());
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response.fail(
					"Response<List<Article>> com.tydic.read.service.impl.ArticleReadServiceImpl.select() query failed");
		}

	}

	@Override
	public Response<ArticleWithBLOBs> find(String id) {
		try {
			return Response.ok(mapper.selectByPrimaryKey(id));
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response.fail(
					"Response<List<Article>> com.tydic.read.service.impl.ArticleReadServiceImpl.find(String id) query failed");
		}
	}

}
