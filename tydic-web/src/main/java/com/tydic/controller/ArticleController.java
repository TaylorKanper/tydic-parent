package com.tydic.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tydic.common.ActionResult;
import com.tydic.common.Response;
import com.tydic.model.Article;
import com.tydic.model.ArticleWithBLOBs;
import com.tydic.read.service.ArticleReadService;
import com.tydic.write.service.ArticleWriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/article")
@Slf4j
public class ArticleController extends BaseController {
	@Resource
	private ArticleReadService articleReadService;
	@Resource
	private ArticleWriteService articleWriteService;

	@RequestMapping("/add")
	public String add() {
		return null;
	}

	@ResponseBody
	@RequestMapping("/addInfo")
	public ActionResult addInfo(ArticleWithBLOBs article) {
		try {
			Response<Integer> res = articleWriteService.add(article);
			if (res.isOk()) {
				return ActionResult.success("添加成功");
			}
			return ActionResult.fail("添加失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ArticleController.addInfo(ArticleWithBLOBs article) error");
			return ActionResult.fail("发生异常： " + e.getMessage());
		}
	}

	@RequestMapping("/index")
	@ResponseBody
	public ModelAndView showAllList() {
		ModelAndView modelAndView = new ModelAndView("/App/OA/Article/index");
		try {
			Response<List<Article>> res = articleReadService.select();
			modelAndView.addObject("list", res.getResult());
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ArticleController.showAllList() error");
			return modelAndView;
		}
	}

	@RequestMapping("/edit")
	@ResponseBody
	public ActionResult modify(String id) {
		try {
			Response<ArticleWithBLOBs> res = articleReadService.find(id);
			return ActionResult.success("成功", res.getResult());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ArticleController.modify(String id) error");
			return ActionResult.fail("发生异常：" + e.getMessage());
		}
	}

	@RequestMapping("/update")
	@ResponseBody
	public ActionResult update(ArticleWithBLOBs article) {
		try {
			Response<Integer> res = articleWriteService.save(article);
			if (res.isOk()) {
				return ActionResult.success("修改成功");
			}
			return ActionResult.fail("修改失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ArticleController.update(ArticleWithBLOBs article) error");
			return ActionResult.fail("发生异常：" + e.getMessage());
		}
	}

	@RequestMapping("/show/{id}")
	public ActionResult showUser(@PathVariable String id) {
		try {
			Response<ArticleWithBLOBs> res = articleReadService.find(id);
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("查询失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ArticleController.showUser(@PathVariable String id) error");
			return ActionResult.fail("发生异常：" + e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping("/delete")
	public ActionResult del(String id) {
		try {
			Response<Integer> res = articleWriteService.delete(id);
			if (res.isOk()) {
				return ActionResult.success("删除成功");
			}
			return ActionResult.fail("删除失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ArticleController.del(String id) error");
			return ActionResult.fail("发生异常：" + e.getMessage());
		}
	}
}
