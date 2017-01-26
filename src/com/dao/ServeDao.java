package com.dao;

import java.util.List;

import com.beans.Serve;

public interface ServeDao extends BaseDao<Serve> {
	public List<Serve> findAll();
}
