package com.hc.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hc.bos.domain.User;

public class BosUtils {
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	public static User getLoginUser(){
		return (User) getSession().getAttribute("loginUser");
	}
}
