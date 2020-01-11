package com.deloitte.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.bean.OrderPage;
import com.deloitte.bean.Menu;
import com.deloitte.dao.IOrderDao;

@Transactional
@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	IOrderDao orderDao;
	
	@Override
	public int confirmOrder(OrderPage ord) {
		return orderDao.confirmOrder(ord);
	}

	@Override
	public List<Menu> getMenu() {
		return orderDao.getMenu();
	}

	@Override
	public List<String> getFoods() {
		return orderDao.getFoods();		
	}

	@Override
	public List<String> getQuantity() {
		return orderDao.getQuantity();
	}

	@Override
	public int updateQuantity(String quantity, int id) {
		// TODO Auto-generated method stub
		return orderDao.updateQuantity(quantity, id);
	}
	
//	@Override
//	public List<Menu> updateMenu() {
//		return orderDao.updateMenu();
//	}

}
