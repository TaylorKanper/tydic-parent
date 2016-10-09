package com.tydic.common;

import java.io.Serializable;

public class Response<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public T result;

	public String error;

	public String errorMessage;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Response(T result, String error) {
		this.result = result;
		this.error = error;
	}

	public Response(T result, String error, String errorMessage) {
		this.result = result;
		this.error = error;
		this.errorMessage = errorMessage;
	}

	public Response() {
	}

	public static <T> Response<T> ok(T result) {
		return new Response<T>(result, null);
	}

	public static <T> Response<T> fail(String error) {
		return new Response<T>(null, error);
	}

	public static <T> Response<T> fail(String error, String errorMessage) {
		return new Response<T>(null, error, errorMessage);
	}

	public static <T> Response<T> fail(T t, String error) {
		return new Response<T>(t, error);
	}

	public boolean isOk() {
		return this.getError() == null;
	}

}
