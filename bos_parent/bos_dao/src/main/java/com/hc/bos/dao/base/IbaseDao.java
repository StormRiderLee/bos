package com.hc.bos.dao.base;

import java.io.Serializable;
import java.util.List;

import com.hc.bos.utils.PageBean;

public interface IbaseDao<T> {
	 public void save(T entity);
	 public void delete(T entity);
	 public void update(T entity);
	 public T fingById(Serializable id);
	 public List<T> findAll();
	 public void pageQuery(PageBean pageBean);
	 public void executeUpdate(String queryName,Object...objects);
	 public void saveOrUpdate(T entity);
}
