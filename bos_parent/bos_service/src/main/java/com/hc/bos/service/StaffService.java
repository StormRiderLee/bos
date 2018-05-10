package com.hc.bos.service;

import com.hc.bos.domain.Staff;
import com.hc.bos.utils.PageBean;

public interface StaffService{

	public void save(Staff model);

	public void pageQuery(PageBean pageBean);

	public void deleteBatch(String dis);

	public Staff findById(String id);

	public void update(Staff staff);
	
}
