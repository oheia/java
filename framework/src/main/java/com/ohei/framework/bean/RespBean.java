package com.ohei.framework.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 响应实体信息
 * @param <T>
 */
@JsonInclude(Include.NON_EMPTY)
public class RespBean<T> extends RespStateBase {

	/**
	 * 对象信息
	 */
	private T t;

	public RespBean() {

	}

	public RespBean(String msg) {
		setMsg(msg);
	}

	public RespBean(T t, String msg) {
		this.t = t;
		setMsg(msg);
	}
	public RespBean(T t) {
		setSuccess(true);
		this.t = t;
	}
	public RespBean(boolean success, T t, String msg) {
		super(success, msg);
		this.t = t;
	}

	public RespBean(boolean success, T t, String msg, String code) {
		super(success, msg, code);
		this.t = t;
	}

	public RespBean(boolean success) {
		setSuccess(success);
	}

	public RespBean(boolean success, String msg) {
		this(success, null, msg);
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
