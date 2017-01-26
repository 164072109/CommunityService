package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Comment;
import com.dao.CommentDao;

@Transactional
@Repository
public class CommentDaoImp implements CommentDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(Comment c) {
		sessionFactory.getCurrentSession().saveOrUpdate(c);
	}

}
