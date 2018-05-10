package com.hc.bos.interceptor;

import com.hc.bos.domain.User;
import com.hc.bos.utils.BosUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BosLoginInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = -3366395118000239555L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = BosUtils.getLoginUser();
		if(user==null){
			return "login";
		}
		//放行
		return invocation.invoke();
	}

}
