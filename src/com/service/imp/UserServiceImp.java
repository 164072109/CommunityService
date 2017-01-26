package com.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beans.User;
import com.dao.UserDAO;
import com.service.UserService;
import com.util.Page;

@Service
public class UserServiceImp extends BaseServiceImp<User> implements UserService {
	@Resource
	private UserDAO userDAO;

	@Override
	public String checkLoginId(String loginId) {
		return userDAO.checkLoginId(loginId);
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public int getTotalNum() {
		return userDAO.getTotalNum();
	}

	@Override
	public List<User> findByPage(Page page) {
		return userDAO.findByPage(page);
	}

	@Override
	public User checkUser(User user) {
		return userDAO.checkUser(user);
	}

}
