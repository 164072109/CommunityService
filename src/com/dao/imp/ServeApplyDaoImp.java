package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.ServeApply;
import com.dao.ServeApplyDao;

@Transactional
@Repository
public class ServeApplyDaoImp extends BaseDaoImp<ServeApply> implements ServeApplyDao {
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ServeApply> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from ServeApply").list();
	}

}
