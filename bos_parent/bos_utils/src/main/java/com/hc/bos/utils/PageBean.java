package com.hc.bos.utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public class PageBean {
	private int currentPage;//当前页
	private int pageSize;//每页显示的记录数
	private int total;//总记录数
	private List rows;//当前页显示的数据集合
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	private DetachedCriteria detachedCriteria;//查询条件
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
}
