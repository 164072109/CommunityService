package com.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beans.Order;
import com.dao.OrderDao;
import com.service.OrderService;

@Service
public class OrderServiceImp extends BaseServiceImp<Order> implements OrderService {
	@Resource
	private OrderDao orderDao;

	@Override
	public boolean checkOrder(Order order) {
		return orderDao.checkOrder(order);
	}

}
