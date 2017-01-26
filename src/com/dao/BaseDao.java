package com.dao;

import java.util.List;

import com.util.Page;

@SuppressWarnings("rawtypes")
public interface BaseDao<I> {
	I getById(int id);

	void add(I I);

	void update(I I);

	void deleteById(int id);

	void delete(I I);

	void saveOrUpdate(I I);

	List findByConditions(String hql, String[] param, Page page);
}
