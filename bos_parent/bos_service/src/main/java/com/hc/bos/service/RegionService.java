package com.hc.bos.service;

import java.util.List;

import com.hc.bos.domain.Region;
import com.hc.bos.utils.PageBean;

public interface RegionService {

	public void save(List<Region> list);

	public void pageQuery(PageBean pageBean);

	public List<Region> findAll();

	public List<Region> findListByq(String q);

	
}
