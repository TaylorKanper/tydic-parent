package com.tydic.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tydic.common.ActionResult;
import com.tydic.common.Response;
import com.tydic.model.Config;
import com.tydic.read.service.ConfigReadService;
import com.tydic.write.service.ConfigWriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/Config")
@Slf4j
public class ConfigController extends BaseController {
	@Resource
	private ConfigReadService configReadService;
	@Resource
	private ConfigWriteService configWriteService;

	@RequestMapping("/index")
	public ActionResult index() {
		try {
			Response<List<Config>> res = configReadService.select();
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("查询失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ConfigController.index() error");
			return ActionResult.fail("发生异常：" + e.getMessage());
		}
	}

	@RequestMapping("/show")
	public ActionResult show(String id) {
		try {
			Response<Config> res = configReadService.find(id);
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("查询失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ConfigController.show(String id) error");
			return ActionResult.fail("发生异常：" + e.getMessage());
		}
	}

	@RequestMapping("/edit")
	public ActionResult edit(String id) {
		try {
			Response<Config> res = configReadService.find(id);
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("查询失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ConfigController.edit(String id) error");
			return ActionResult.fail("发生异常：" + e.getMessage());
		}
	}

	@RequestMapping("/update")
	@ResponseBody
	public ActionResult update(Config info) {
		try {
			Response<Integer> res = configWriteService.save(info);
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("修改失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.ConfigController.update(Config info) error");
			return ActionResult.fail("发生异常：" + e.getMessage());
		}
	}
}