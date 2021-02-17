package com.ohei.framework.exception;

/**
 *  业务异常
 */
public class BusinessException extends BaseException {
    private static final long serialVersionUID = -77488374980586210L;

    private static final int CODE = 400;

    public BusinessException() {
        super(CODE, "业务异常!");
    }

    public BusinessException(String message) {
        super(CODE,message);
    }
}
