package com.hc.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.bos.dao.UserDao;
import com.hc.bos.domain.User;
import com.hc.bos.service.UserService;
import com.hc.bos.utils.MD5Utils;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override

	public User login(User model) {
		String password = MD5Utils.md5(model.getPassword());
		return userDao.findUsernameByPassword(model.getUsername(),password);
	}
	public void editPassword(String id, String password) {
		//使用MD5加密密码
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", password,id);
	}
}
