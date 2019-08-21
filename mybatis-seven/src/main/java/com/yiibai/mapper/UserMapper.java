package com.yiibai.mapper;

import java.util.List;

import com.yiibai.pojo.Order;
import com.yiibai.pojo.User;

public interface UserMapper {

	public User getUserById(int i);

	public List<Order> getUserOrders(int i);

}
