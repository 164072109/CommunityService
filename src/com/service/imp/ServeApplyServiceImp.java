package com.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beans.ServeApply;
import com.dao.ServeApplyDao;
import com.service.ServeApplyService;

@Service
public class ServeApplyServiceImp extends BaseServiceImp<ServeApply> implements ServeApplyService {
	@Resource
	private ServeApplyDao serveApplyDao;

	@Override
	public List<ServeApply> findAll() {
		return serveApplyDao.findAll();
	}

}
