package com.ohei.framework.bean;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分页信息
 * @ClassName: PageData
 * @Description: 分页封装类
 *
 */
public class PageData<T> implements java.io.Serializable {

	private static final long serialVersionUID = -8693030649367790726L;
	/**
	 * 数据列表
	 */
	private List<T> data;
	/**
	 * 总条数
	 */
	private int totalCount;
	/**
	 * 其他的数据map信息
	 */
	private Map<String, Object> otherData;

	public PageData() {

	}

	public PageData(List<T> data) {
		this.data = data;
		this.totalCount = data.size();
	}

	public PageData(List<T> data, Map<String, Object> otherData) {
		this.data = data;
		this.totalCount = data.size();
		this.otherData = otherData;
	}

	public PageData(List<T> data, int totalCount) {
		this.data = data;
		this.totalCount = totalCount;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Map<String, Object> getOtherData() {
		return otherData;
	}

	public void setOtherData(Map<String, Object> otherData) {
		this.otherData = otherData;
	}

	public <M,V> PageData<V> tovo(Class<V> c) {
		return new PageData<V>(this.getData().stream().map(m -> {
			V v = null;
			try {
				v = c.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			BeanUtils.copyProperties(m, v);
			return v;
		}).collect(Collectors.toList()), this.totalCount);
	}
}
