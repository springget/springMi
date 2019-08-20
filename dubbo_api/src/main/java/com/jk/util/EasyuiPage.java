/** 
 * <pre>项目名称:book 
 * 文件名称:EasyuiPage.java 
 * 包名:com.jk.gyh.utils 
 * 创建日期:2019年2月15日上午11:51:02 
 * Copyright (c) 2019, All Rights Reserved.</pre> 
 */  
package com.jk.util;


public class EasyuiPage {

	private Integer total; //总条数
	private Object rows;// list 数据
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "EasyuiPage [total=" + total + ", rows=" + rows + "]";
	}
	
}
