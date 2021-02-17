package com.ohei.framework.bean;


/**
 * 分页信息
 */
public class PageBean {
	private static final int DEFAULT_PAGE = 1;
	private static final int DEFAULT_ROW = 10;
	/**
	 * 当前页数
	 */
	private int page;
	/**
	 * 从第几条开始
	 */
	private Integer start;
	/**
	 * 每页显示几条记录
	 */
	private Integer rows;

	public PageBean() {
		this(DEFAULT_PAGE, DEFAULT_ROW);
	}

	/**
	 * 
	 * @param page
	 * @param rows
	 */
	public PageBean(Integer page, Integer rows) {
		// page如果小于1，设置默认值
		this.page = ((page == null || page < 1) ? DEFAULT_PAGE : page);
		// rows如果小于1，设置默认值
		this.rows = ((rows == null || rows < 1) ? DEFAULT_ROW : rows);
	}

	/**
	 * 当前页数
	 */
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if (page == null || page < 1) {
			this.page = DEFAULT_PAGE;
		} else {
			this.page = page;
		}
	}

	/**
	 * 每页显示记录数
	 */
	public Integer getRows() {
		if (rows == null || rows < 1) {
			this.rows = DEFAULT_ROW;
		}
		return rows;
	}

	public void setRows(Integer rows) {
		if (rows == null || rows < 1) {
			this.rows = DEFAULT_ROW;
		} else {
			this.rows = rows;
		}
	}

	/**
	 * 从第几条开始
	 */
	public Integer getStart() {
		this.start = (this.page - 1) * this.rows;
		return start;
	}


	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", start=" + getStart() + "]";
	}

//	public static void main(String[] args) {
//		Integer idx = 1;
//		Integer rows = 13;
//		PageBean page = new PageBean(idx, rows);
//		LogUtil.info("start==" + page.getStart() + ",rows==" + page.getRows());
//	}
}
