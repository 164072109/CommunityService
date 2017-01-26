package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.ServeInfo;
import com.service.ServeService;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ServeService sc = (ServeService) ac.getBean("serveService");
		 //System.out.println(sc.findAll().size());
		List<ServeInfo> si = sc.findAll().get(0).getServeInfo();
		System.out.println(si.get(0).getId());
		// UserService us = (UserService) ac.getBean("userService");
		// User user = new User();
		// user.setLoginId("123");
		// user.setPasswd("123");
		// us.checkUser(user);

	}

}
