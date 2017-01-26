package com.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beans.Admin;
import com.dao.AdminDao;
import com.service.AdminService;

@Service
public class AdminServiceImp extends BaseServiceImp<Admin> implements AdminService {
	@Resource
	private AdminDao adminDao;

}
