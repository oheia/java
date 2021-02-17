package com.ohei.framework.bean;

import lombok.Data;

import java.util.List;

/**
 * 响应列表信息
 * @param <T>
 * @param <O>
 */
@Data
public class RespListOtherBean<T, O> extends RespStateBase {

	/**
	 * 数据列表
	 */
	private List<T> rows;
	/**
	 * 总条数
	 */
	private int total;

	/**
	 * 其他信息
	 */
	private O other;

	public RespListOtherBean() {

	}

	public RespListOtherBean(String msg) {
		setMsg(msg);
	}

	public RespListOtherBean(boolean success) {
		setSuccess(success);
	}

	public RespListOtherBean(boolean success, String msg) {
		super(success, msg);
	}

	public RespListOtherBean(List<T> rows, O other) {
		if (rows != null) {
			this.rows = rows;
			this.total = rows.size();
			setSuccess(true);
		}
		this.other = other;
	}

	public RespListOtherBean(int total, List<T> rows, O other) {
		this(total, rows, other, true);
	}

	public RespListOtherBean(PageOtherData<T, O> pageData) {
		this(pageData, true);
	}

	public RespListOtherBean(PageOtherData<T, O> pageData, boolean success) {
		if (pageData != null) {
			this.rows = pageData.getData();
			this.total = pageData.getTotalCount();
			this.other = pageData.getOther();
			setSuccess(success);
		}
	}

	public RespListOtherBean(PageOtherData<T, O> pageData, boolean success, String msg) {
		if (pageData != null) {
			this.rows = pageData.getData();
			this.total = pageData.getTotalCount();
			this.other = pageData.getOther();
			setSuccess(success);
			setMsg(msg);
		}
	}

	public RespListOtherBean(int total, List<T> rows, O other, boolean success) {
		this.rows = rows;
		this.total = total;
		setSuccess(success);
	}

}
