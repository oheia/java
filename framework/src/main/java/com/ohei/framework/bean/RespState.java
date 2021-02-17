package com.ohei.framework.bean;

/**
 * 响应状态信息类
 */
public class RespState extends RespStateBase {

	public RespState() {
	}

	public RespState(boolean success) {
		this.success = success;
	}

	public RespState(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public RespState(boolean success, String msg, String code) {
		super();
		this.success = success;
		this.msg = msg;
	}
}