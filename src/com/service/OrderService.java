package com.service;

import com.beans.Order;

public interface OrderService extends BaseService<Order> {

	boolean checkOrder(Order order);

}
