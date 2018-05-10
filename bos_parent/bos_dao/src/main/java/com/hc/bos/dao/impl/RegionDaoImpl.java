package com.hc.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hc.bos.dao.RegionDao;
import com.hc.bos.dao.base.impl.IbaseDaoImpl;
import com.hc.bos.domain.Region;
@Repository
public class RegionDaoImpl extends IbaseDaoImpl<Region> implements RegionDao {

	@Override
	public List<Region> findListByq(String q) {
		String hql = "from Region where shortcode like ? or citycode like ? or province like ? or city like ? or district like ?";
		return (List<Region>) this.getHibernateTemplate().find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
	}
	
}
