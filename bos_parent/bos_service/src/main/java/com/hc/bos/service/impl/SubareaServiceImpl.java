package com.hc.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.bos.dao.SubareaDao;
import com.hc.bos.domain.Subarea;
import com.hc.bos.service.SubareaService;
@Service
@Transactional
public class SubareaServiceImpl implements SubareaService {
	@Autowired
	private SubareaDao subareaDao;

	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
	}
}
