package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Order;
import com.dao.OrderDao;

@Transactional
@Repository
public class OrderDaoImp extends BaseDaoImp<Order> implements OrderDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public boolean checkOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order where state=? and user.id=? and employee.id=?");
		query.setString(0, order.getState());
		query.setInteger(1, order.getUser().getId());
		query.setInteger(2, order.getEmployee().getId());
		if (query.uniqueResult() == null) {
			return false;
		} else {
			return true;
		}

	}

}
