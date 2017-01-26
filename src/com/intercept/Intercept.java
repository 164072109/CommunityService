package com.intercept;

import org.apache.struts2.ServletActionContext;

import com.beans.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class Intercept extends MethodFilterInterceptor {

	@Override
	public void destroy() {
		System.out.println("======Ïú»ÙÀ¹½ØÆ÷=========");
		super.destroy();
	}

	@Override
	public void init() {
		System.out.println("=======Æô¶¯À¹½ØÆ÷=========");
		super.init();
	}

	@Override
	protected String doIntercept(ActionInvocation paramActionInvocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		if (user != null) {
			return paramActionInvocation.invoke();
		}
		System.out.println("======ÇëÏÈµÇÂ¼========");
		return "login";
	}

}
