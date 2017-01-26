package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.User;
import com.dao.UserDAO;
import com.util.Page;

@Transactional
@Repository
public class UserDAOImp extends BaseDaoImp<User> implements UserDAO {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public User checkUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where loginId=? and passwd=?");
		query.setString(0, user.getLoginId());
		query.setString(1, user.getPasswd());
		return (User) query.uniqueResult();
	}

	@Override
	public String checkLoginId(String loginId) {
		Query query = sessionFactory.getCurrentSession().createQuery("select loginId from User where loginId=?");
		query.setString(0, loginId);
		return (String) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.list();
	}

	@Override
	public int getTotalNum() {
		Number num = (Number) sessionFactory.getCurrentSession().createQuery("select count(*) from User")
				.uniqueResult();
		return num.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByPage(Page page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		query.setMaxResults(page.getEveryPageNum());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}
}
