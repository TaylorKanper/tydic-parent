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
import com.tydic.model.User;
import com.tydic.read.service.UserReadService;
import com.tydic.write.service.UserWriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController {
	@Resource
	private UserReadService userReadService;
	@Resource
	private UserWriteService userWriteService;
	@RequestMapping("/indexpage")
	public ModelAndView indexpage() {
		return new ModelAndView("index");
	}
	@RequestMapping("/index")
	@ResponseBody
	public ActionResult showAllList() {
		try {
			Response<List<User>> res = userReadService.select();
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("查询失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.UserController.showAllList() error");
			return ActionResult.fail("发生异常: " + e.getMessage());
		}
	}

	@RequestMapping("/show")
	public ActionResult showUser(String uid) {
		try {
			Response<User> res = userReadService.find(uid);
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("查询失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.UserController.showUser(String uid) error");
			return ActionResult.fail("发生异常: " + e.getMessage());
		}
	}
	@RequestMapping("/{id}/show")
	public ActionResult showUser2(@PathVariable String id) {
		try {
			Response<User> res = userReadService.find(id);
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("查询失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.UserController.showUser2(@PathVariable String id) error");
			return ActionResult.fail("发生异常: " + e.getMessage());
		}
	}

	@RequestMapping("/edit")
	public ActionResult modify(String uid) {
		try {
			Response<User> res = userReadService.find(uid);
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("查询失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.UserController.modify(String uid) error");
			return ActionResult.fail("发生异常: " + e.getMessage());
		}
	}

	@RequestMapping("/update")
	@ResponseBody
	public ActionResult update(User info) {
		try {
			Response<Integer> res = userWriteService.save(info);
			if (res.isOk()) {
				return ActionResult.success("成功", res.getResult());
			}
			return ActionResult.fail("修改失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ActionResult com.tydic.controller.UserController.update(User info) error");
			return ActionResult.fail("发生异常: " + e.getMessage());
		}
	}

}