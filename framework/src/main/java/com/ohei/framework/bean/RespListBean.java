package com.ohei.framework.bean;

import java.util.List;

/**
 * 响应列表信息
 * @param <T>
 */
public class RespListBean<T> extends RespStateBase {

	private static final long serialVersionUID = -2941694966710297115L;
	/**
	 * 数据列表
	 */
	private List<T> rows;
	/**
	 * 总条数
	 */
	private int total;

	public RespListBean() {

	}

	public RespListBean(String msg) {
		setMsg(msg);
	}

	public RespListBean(boolean success) {
		setSuccess(success);
	}

	public RespListBean(boolean success, String msg) {
		super(success, msg);
	}

	public RespListBean(List<T> rows) {
		if (rows != null) {
			this.rows = rows;
			this.total = rows.size();
			setSuccess(true);
		}
	}

	public RespListBean(int total, List<T> rows) {
		this(total, rows, true);
	}

	public RespListBean(PageData<T> pageData) {
		this(pageData, true);
	}

	public RespListBean(PageData<T> pageData, boolean success) {
		if (pageData != null) {
			this.rows = pageData.getData();
			this.total = pageData.getTotalCount();
			setSuccess(success);
		}
	}

	public RespListBean(PageData<T> pageData, boolean success, String msg) {
		if (pageData != null) {
			this.rows = pageData.getData();
			this.total = pageData.getTotalCount();
			setSuccess(success);
			setMsg(msg);
		}
	}

	public RespListBean(int total, List<T> rows, boolean success) {
		this.rows = rows;
		this.total = total;
		setSuccess(success);
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
