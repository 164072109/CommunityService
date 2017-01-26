package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Serve;
import com.dao.ServeDao;

@Transactional
@Repository
public class ServeDaoImp extends BaseDaoImp<Serve> implements ServeDao {
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Serve> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Serve");
		return query.list();
	}

}
