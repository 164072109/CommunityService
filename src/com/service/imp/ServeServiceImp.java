package com.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beans.Serve;
import com.dao.ServeDao;
import com.service.ServeService;

@Service
public class ServeServiceImp extends BaseServiceImp<Serve> implements ServeService {
	@Resource
	private ServeDao serveDao;

	@Override
	public List<Serve> findAll() {
		return serveDao.findAll();
	}

}
