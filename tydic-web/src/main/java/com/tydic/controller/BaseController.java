package com.tydic.controller;

import javax.servlet.http.HttpServletRequest;


public class BaseController {

	// 获取基于应用程序的url绝对路径
	public final String getAppbaseUrl(HttpServletRequest request, String url){
		return request.getContextPath() + url;
	}
	
	// 根据url获取当前控制器名称
	@SuppressWarnings("null")
	public String[] controllerName(){
		HttpServletRequest request = null;
		String url = request.getRequestURI();
		String[] urlArr = url.split("/");
		return urlArr;
	}
	
	// 根据url获取当前操作名称
	public String actionName(String url){
		return url;
	}
	
}
