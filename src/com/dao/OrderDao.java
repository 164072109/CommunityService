package com.dao;

import com.beans.Order;

public interface OrderDao extends BaseDao<Order> {

	boolean checkOrder(Order order);

}
