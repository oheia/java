package com.ohei.framework.bean;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 分页信息
 * @ClassName: PageData
 * @Description: 分页封装类
 *
 */
@Data
public class PageOtherData<T, O> {

	/**
	 * 数据列表
	 */
	private List<T> data;
	/**
	 * 总条数
	 */
	private int totalCount;
	/**
	 * 其他的数据信息
	 */
	private O other;

	public PageOtherData() {

	}

	public PageOtherData(List<T> data) {
		this.data = data;
		this.totalCount = data.size();
	}

	public PageOtherData(List<T> data, O other) {
		this.data = data;
		this.totalCount = data.size();
		this.other = other;
	}

	public PageOtherData(List<T> data, int totalCount) {
		this.data = data;
		this.totalCount = totalCount;
	}

	public PageOtherData(List<T> data, int totalCount, O other) {
		this.data = data;
		this.totalCount = totalCount;
		this.other = other;
	}

	public <V> PageOtherData<V, O> tovo(Class<V> c) {
		PageOtherData pagingData =  new PageOtherData<V, O>(this.getData().stream().map(m -> {
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
		pagingData.setOther(this.other);
		return pagingData;
	}
}
