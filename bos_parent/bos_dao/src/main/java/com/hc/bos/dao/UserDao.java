package com.hc.bos.dao;

import com.hc.bos.dao.base.IbaseDao;
import com.hc.bos.domain.User;

public interface UserDao extends IbaseDao<User> {

	User findUsernameByPassword(String username, String password);

	public void executeUpdate(String queryName,Object...objects);
}
