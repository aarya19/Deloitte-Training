package com.deloitte.dao;

import java.util.List;

import com.deloitte.bean.OrderPage;
import com.deloitte.bean.Menu;

public interface IOrderDao {

	int confirmOrder(OrderPage ord);

	List<Menu> getMenu();

	List<String> getFoods();

	List<String> getQuantity();

	int updateQuantity(String quantity, int id);

//	List<Menu> updateMenu();

}
