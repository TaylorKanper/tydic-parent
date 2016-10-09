package com.tydic.common;

import java.io.Serializable;

public class ActionResult implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 操作结果代码 0 - 成功 1 - 失败 2 - 无权限 3 - 未登录 4 - 超时
	 */
	private int code = 0;

	/**
	 * 操作结果的描述
	 */
	private String msg = "";

	/**
	 * 返回的数据
	 */
	private Object data = null;

	/**
	 * 默认构造函数
	 */
	public ActionResult() {
	}

	/**
	 * 构造函数
	 * 
	 * @param code
	 *            操作结果代码
	 * @param message
	 *            操作结果的描述
	 * @param data
	 *            返回数据
	 */
	public ActionResult(int code, String message, Object data) {
		this.code = code;
		this.msg = message;
		this.data = data;
	}

	/**
	 * 操作成功（0：成功）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @return ActionResult
	 */
	public static ActionResult success(String message) {
		return new ActionResult(0, message, null);
	}

	/**
	 * 操作成功（0：成功）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @param data
	 *            返回数据
	 * @return ActionResult
	 */
	public static ActionResult success(String message, Object data) {
		return new ActionResult(0, message, data);
	}

	/**
	 * 操作失败（1：失败）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @return ActionResult
	 */
	public static ActionResult fail(String message) {
		return new ActionResult(1, message, null);
	}

	/**
	 * 操作失败（1：失败）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @param data
	 *            返回数据
	 * @return ActionResult
	 */
	public static ActionResult fail(String message, Object data) {
		return new ActionResult(1, message, data);
	}

	/**
	 * 未获得权限（2：无权限）
	 * 
	 * @param message
	 * @return ActionResult
	 */
	public static ActionResult noauth(String message) {
		return new ActionResult(2, message, null);
	}

	/**
	 * 未获得权限（2：无权限）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @param data
	 *            返回数据
	 * @return ActionResult
	 */
	public static ActionResult noauth(String message, Object data) {
		return new ActionResult(2, message, data);
	}

	/**
	 * 未登录（3：未登录）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @return ActionResult
	 */
	public static ActionResult nologin(String message) {
		return new ActionResult(3, message, null);
	}

	/**
	 * 未登录（3：未登录）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @param data
	 *            返回数据
	 * @return ActionResult
	 */
	public static ActionResult nologin(String message, Object data) {
		return new ActionResult(3, message, data);
	}

	/**
	 * session超时（4：超时）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @return ActionResult
	 */
	public static ActionResult timeout(String message) {
		return new ActionResult(4, message, null);
	}

	/**
	 * session超时（4：超时）
	 * 
	 * @param message
	 *            操作结果的描述
	 * @param data
	 *            返回数据
	 * @return ActionResult
	 */
	public static ActionResult timeout(String message, Object data) {
		return new ActionResult(4, message, data);
	}

	/**
	 * 获取操作结果代码
	 * 
	 * @return 操作结果代码
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 设置操作结果代码
	 * 
	 * @param code
	 *            操作结果代码
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 获取操作结果的描述
	 * 
	 * @return 操作结果的描述
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设定操作结果的描述
	 * 
	 * @param msg
	 *            操作结果的描述
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取返回数据
	 * 
	 * @return 返回数据
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 设置返回数据
	 * 
	 * @param data
	 *            返回数据
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
