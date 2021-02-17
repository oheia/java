package com.ohei.framework.exception;

/**
 * 参数异常类
 */
public class ParaException extends BaseException {
	private static final long serialVersionUID = 3882335138261136083L;
	public static final int code = 403;

	public ParaException() {
		super(code, "参数异常");
	}

	public ParaException(String msg) {
		super(code, msg);
	}

}
