package com.ohei.framework.exception;

import lombok.Data;

/**
 * 自定义异常基类
 */
@Data
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 8429855003432829089L;

    private String message = "系统异常";
    private int code;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public BaseException(int code) {
        this.code = code;
    }

    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
