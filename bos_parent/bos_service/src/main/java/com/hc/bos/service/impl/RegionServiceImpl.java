package com.hc.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.bos.dao.RegionDao;
import com.hc.bos.domain.Region;
import com.hc.bos.service.RegionService;
import com.hc.bos.utils.PageBean;
@Service
@Transactional
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegionDao regionDao;
	public void setRegionDao(RegionDao regionDao) {
		this.regionDao = regionDao;
	}
	@Override
	public void save(List<Region> list) {
		for (Region region : list) {
			regionDao.saveOrUpdate(region);
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
	}
	@Override
	public List<Region> findAll() {
		return regionDao.findAll();
	}
	@Override
	public List<Region> findListByq(String q) {
		return regionDao.findListByq(q);
	}

}
