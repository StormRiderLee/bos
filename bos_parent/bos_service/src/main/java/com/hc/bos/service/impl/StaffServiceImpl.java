package com.hc.bos.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.bos.dao.StaffDao;
import com.hc.bos.domain.Staff;
import com.hc.bos.service.StaffService;
import com.hc.bos.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;
	@Override
	public void save(Staff model) {
		staffDao.save(model);
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}
	@Override
	public void deleteBatch(String dis) {
		if(StringUtils.isNoneBlank(dis)){
			String[] split = dis.split(",");
			for (String id : split) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}
	@Override
	public Staff findById(String id) {
		return staffDao.fingById(id);
	}
	@Override
	public void update(Staff staff) {
		staffDao.update(staff);
	}
	
}
