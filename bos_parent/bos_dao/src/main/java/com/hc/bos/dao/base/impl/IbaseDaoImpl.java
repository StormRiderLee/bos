package com.hc.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.hc.bos.dao.base.IbaseDao;
import com.hc.bos.utils.PageBean;

public class IbaseDaoImpl<T> extends HibernateDaoSupport implements IbaseDao<T> {
	private Class<T> entityClass;
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	public IbaseDaoImpl() {
		ParameterizedType pt =  (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = pt.getActualTypeArguments();
		entityClass = (Class<T>) types[0];
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
		
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
		
	}

	@Override
	public T fingById(Serializable id) {
		
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		String hql = "FROM " + entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		int total = list.get(0).intValue();
		pageBean.setTotal(total);
		detachedCriteria.setProjection(null);
		int firstResult = (currentPage-1)*pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
	}
	@Override
	public void executeUpdate(String queryName, Object... objects) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		for (Object object : objects) {
			//为HQL语句中的？赋值
			query.setParameter(i++, object);
		}
		//执行更新
		query.executeUpdate();
	}
	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

}
