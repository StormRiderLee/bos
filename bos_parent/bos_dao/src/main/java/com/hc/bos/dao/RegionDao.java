package com.hc.bos.dao;

import java.util.List;

import com.hc.bos.dao.base.IbaseDao;
import com.hc.bos.domain.Region;
public interface RegionDao extends IbaseDao<Region>{

	List<Region> findListByq(String q);

}
