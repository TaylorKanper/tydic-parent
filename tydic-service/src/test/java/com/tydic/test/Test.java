package com.tydic.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tydic.common.Response;
import com.tydic.model.Article;
import com.tydic.read.service.ArticleReadService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-base.xml" })
public class Test {
	@Resource
	private ArticleReadService articleReadService;

	@org.junit.Test
	public void test() {
		try {
			Response<List<Article>> res = articleReadService.select();
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
