package com.service;

import java.util.List;

import com.beans.Serve;

public interface ServeService extends BaseService<Serve> {
	public List<Serve> findAll();

}
