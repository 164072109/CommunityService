package com.dao;

import java.util.List;

import com.beans.User;
import com.util.Page;

public interface UserDAO extends BaseDao<User> {
	User checkUser(User user);

	String checkLoginId(String loginId);

	List<User> getAll();

	int getTotalNum();

	List<User> findByPage(Page page);
}
