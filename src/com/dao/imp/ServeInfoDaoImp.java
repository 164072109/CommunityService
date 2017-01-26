package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.ServeInfo;
import com.dao.ServeInfoDao;

@Transactional
@Repository
public class ServeInfoDaoImp implements ServeInfoDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void add(ServeInfo serveInfo) {
		sessionFactory.getCurrentSession().save(serveInfo);
	}

}
