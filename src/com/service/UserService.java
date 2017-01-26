package com.service;

import java.util.List;

import com.beans.User;
import com.util.Page;

public interface UserService extends BaseService<User> {

	public String checkLoginId(String loginId);

	public List<User> getAll();

	public int getTotalNum();

	public List<User> findByPage(Page page);

	public User checkUser(User user);
}
