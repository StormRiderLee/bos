package com.hc.bos.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.hc.bos.dao.UserDao;
import com.hc.bos.dao.base.impl.IbaseDaoImpl;
import com.hc.bos.domain.User;
@SuppressWarnings("all")
@Repository
public class UserDaoImpl extends IbaseDaoImpl<User> implements UserDao{

	@Override
	public User findUsernameByPassword(String username, String password) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User u where u.username = ? and u.password = ?",username,password);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	
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
}
