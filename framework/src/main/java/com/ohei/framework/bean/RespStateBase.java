package com.ohei.framework.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 响应实体基类
 */

@Data
@ToString
public class RespStateBase implements Serializable {
    private static final long serialVersionUID = 1938755162504996140L;
    /**
     * 是否成功（true：成功，false：失败）
     */
    protected boolean success;
    /**
     * 返回的信息描述
     */
    protected String msg = "ok";
    /**
     * 返回代码
     */
    protected int code = 0;

    public RespStateBase() {
    }

    public RespStateBase(boolean success) {
        this.success = success;
    }

    public RespStateBase(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }

    public RespStateBase(boolean success, String msg, String code) {
        super();
        this.success = success;
        this.msg = msg;
    }
}
