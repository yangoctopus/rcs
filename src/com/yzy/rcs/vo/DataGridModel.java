package com.yzy.rcs.vo;

import java.util.List;

public class DataGridModel<T> {
	//响应到客户端的集合数据（需要显示的数据）
	private List<T> rows;
	//响应到客户端的总行数
	private Integer total;
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
