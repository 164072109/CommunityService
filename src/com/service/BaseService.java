package com.service;

import java.util.List;

import com.util.Page;

@SuppressWarnings("rawtypes")
public interface BaseService<I> {
	I getById(int id);

	void add(I I);

	void update(I I);

	void addOrUpdate(I I);

	void deleteById(int id);

	void delete(I I);

	List findByConditions(String hql, String[] param, Page page);
}
