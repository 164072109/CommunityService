package com.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beans.ServeInfo;
import com.dao.ServeInfoDao;
import com.service.ServeInfoService;
@Service
public class ServeInfoServiceImp implements ServeInfoService {
	@Resource
	private ServeInfoDao serveInfoDao;

	@Override
	public void add(ServeInfo serveInfo) {
		serveInfoDao.add(serveInfo);
	}

}
