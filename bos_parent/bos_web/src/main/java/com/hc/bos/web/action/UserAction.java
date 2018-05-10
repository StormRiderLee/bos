package com.hc.bos.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hc.bos.domain.User;
import com.hc.bos.service.UserService;
import com.hc.bos.utils.BosUtils;
import com.hc.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	private static final long serialVersionUID = 1232759086176015404L;
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	@Autowired
	private UserService userService;
	public String login(){
		String Vcode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(StringUtils.isNoneBlank("checkcode") && checkcode.equals(Vcode)){
			User user = userService.login(model);
			if(user != null){
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return "index";
			}else{
				this.addActionError("账号或密码不对");
				return "login";
			}
		}else{
			this.addActionError("你输入的验证码不对");
			return "login";
		}
	}
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
	public String editPassword() throws IOException{
		String f = "1";
		//获取当前登录用户
		User user = BosUtils.getLoginUser();
		try{
			userService.editPassword(user.getId(),model.getPassword());
		}catch(Exception e){
			f = "0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
}
