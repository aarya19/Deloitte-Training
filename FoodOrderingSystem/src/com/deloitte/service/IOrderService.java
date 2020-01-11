package com.deloitte.service;

import java.util.List;

import com.deloitte.bean.OrderPage;
import com.deloitte.bean.Menu;

public interface IOrderService {

	List<String> getFoods();

	int confirmOrder(OrderPage ord);

	List<Menu> getMenu();

	List<String> getQuantity();

	int updateQuantity(String quantity, int id);

//	List<Menu> updateMenu();

}
