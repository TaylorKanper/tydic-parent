package com.tydic.write.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tydic.common.Response;
import com.tydic.model.Article;
import com.tydic.model.ArticleWithBLOBs;
import com.tydic.persist.ArticleMapper;
import com.tydic.write.service.ArticleWriteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleWriteServiceImpl implements ArticleWriteService {
	@Resource
	private ArticleMapper mapper;

	@Override
	public Response<Integer> delete(String id) {
		try {
			return Response.ok(mapper.deleteByPrimaryKey(id));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("database error: " + e.getMessage());
			return Response.fail(
					"Response<Integer> com.tydic.write.service.impl.ArticleWriteServiceImpl.delete(String id) delete failed");
		}
	}

	@Override
	public Response<Integer> save(Article articleInfo) {
		try {
			articleInfo.setUtime(System.currentTimeMillis());
			return Response.ok(mapper.updateByPrimaryKeySelective(articleInfo));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("database error: " + e.getMessage());
			return Response.fail(
					"Response<Integer> com.tydic.write.service.impl.ArticleWriteServiceImpl.save(Article articleInfo) save fail");
		}
	}

	@Override
	public Response<Integer> add(ArticleWithBLOBs articleInfo) {
		try {
			articleInfo.setId(UUID.randomUUID().toString());
			articleInfo.setVisitnums(0);
			articleInfo.setCtime(System.currentTimeMillis());
			return Response.ok(mapper.insertSelective(articleInfo));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("database error: " + e.getMessage());
			return Response.fail(
					"Response<Integer> com.tydic.write.service.impl.ArticleWriteServiceImpl.add(ArticleWithBLOBs articleInfo) add fail");
		}
	}

}
