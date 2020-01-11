package com.deloitte.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deloitte.bean.OrderPage;
import com.deloitte.bean.Menu;
import com.deloitte.service.IOrderService;

@Controller
public class OrderController {
	@Autowired
	IOrderService orderService;

	List<String> foodList = null;
	List<String> quantity = null;
	List<Menu> ordlist;
	List<OrderPage> OPlist;

	@RequestMapping(value = "/confirmOrder.obj")
	public String redirectToconfirmOrder(Model model){
		OrderPage ord = new OrderPage();
		foodList = orderService.getFoods();
		quantity = orderService.getQuantity();
		model.addAttribute("flist", foodList);
		model.addAttribute("qtylist", quantity);
		model.addAttribute("ord", ord);
//	    ordlist = orderService.getMenu();
		return "orderForm";
	}

	@RequestMapping(value = "/placeOrder.obj")
	public String confirmOrder(
			@ModelAttribute(value = "ord") @Valid OrderPage ord,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			foodList = orderService.getFoods();
			quantity = orderService.getQuantity();
			model.addAttribute("flist", foodList);
			model.addAttribute("qtylist", quantity);
			return "orderForm";
		} else {
			int output = orderService.confirmOrder(ord);
			model.addAttribute("id", ord.getId());
			model.addAttribute("foods", ord.getFoods());
			String food = ord.getFoods();
			int id;
			if(food.equals("Chilli chicken")) {
				id = 1;
			}
			else if(food.equals("Chilli Paneer")) {
				id = 2;
			}
			else if(food.equals("Dosa")) {
				id = 3;
			}
			else if(food.equals("Gulab jamun")) {
				id = 4;
			}
			else if(food.equals("Green tea")) {
				id = 5;
			}
			else {
				id=0;
			}
			System.out.println("id in controller is "+id);
			model.addAttribute("quantity", ord.getQuantity());
			int row = orderService.updateQuantity(ord.getQuantity(),id);
			if(row!=-1) {if (output == 1) {
				model.addAttribute("olist", OPlist);
				return "successOrder";
			} else {
				return null;
			}}
			else {
				return "failOrder";
			}
		}
	}

	@RequestMapping(value = "/showMenu.obj")
	public String showMenu(Model model) {
		ordlist = orderService.getMenu();
		model.addAttribute("elist", ordlist);
		return "showMenu";
	}

	@RequestMapping(value = "/goHome.obj")
	public String goToHome(Model model) {
		return "index";
	}

}

