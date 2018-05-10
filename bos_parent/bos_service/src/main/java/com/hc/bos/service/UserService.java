package com.hc.bos.service;

import com.hc.bos.domain.User;

public interface UserService {

	public User login(User model);

	
	public void editPassword(String id, String password);
}
