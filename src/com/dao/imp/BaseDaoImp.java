package com.dao.imp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BaseDao;
import com.util.Page;

@SuppressWarnings("unchecked")
@Transactional
public class BaseDaoImp<I> implements BaseDao<I> {
	private Class<I> I;
	@Resource
	private SessionFactory sessionFactory;

	public BaseDaoImp() {
		System.out.println("=====BaseDaoImp≥ı ºªØ======");
		Type type = getClass().getGenericSuperclass();
		this.I = (Class<I>) ((ParameterizedType) type).getActualTypeArguments()[0];
		System.out.println(I.getName());
	}

	@Override
	public I getById(int id) {
		System.out.println("======BaseDao:getById==id: " + id);
		return (I) sessionFactory.getCurrentSession().get(I, id);
	}

	@Override
	public void add(I I) {
		System.out.println("========BaseDao:add=======================");
		sessionFactory.getCurrentSession().save(I);
	}

	@Override
	public void update(I I) {
		System.out.println("========BaseDao:update=======================");
		sessionFactory.getCurrentSession().update(I);
	}

	@Override
	public void deleteById(int id) {
		System.out.println("========BaseDao:deleteById=================");
		sessionFactory.getCurrentSession().delete(getById(id));
	}

	@Override
	public void saveOrUpdate(I I) {
		System.out.println("========BaseDao:saveOrUpdate=================");
		sessionFactory.getCurrentSession().saveOrUpdate(I);
	}

	@Override
	public void delete(I I) {
		System.out.println("========BaseDao:delete=================");
		sessionFactory.getCurrentSession().delete(I);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findByConditions(String hql, String[] param, Page page) {
		System.out.println("========BaseDao:findByConditions=================");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (param != null && param.length != 0) {
			for (int i = 0; i < param.length; i++) {
				query.setString(i, param[i]);
			}
		}
		if (page != null) {
			query.setMaxResults(page.getEveryPageNum());
			query.setFirstResult(page.getBeginIndex());
		}
		return query.list();

	}

}
