package com.deloitte.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deloitte.bean.User;
import com.deloitte.exception.UserException;
import com.deloitte.service.IUserService;

@Controller
public class UserController {
	@Autowired
	 IUserService userService;
	List<User> ulist;

	@RequestMapping(value = "/register.obj")
	public String redirectToAddAthlete(Model model) throws UserException {
		User user = new User();
		model.addAttribute("user", user);
		return "LoginForm";
	}
	
	@RequestMapping(value = "/submitUser.obj")
	public String addUser(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult, Model model)
			throws UserException {
				if (bindingResult.hasErrors()) {
	
			return "LoginForm";
		} else {
			int output = userService.addUser(user);
			if (output == 1) {
				return "successAdd";
			} else {
				return "userAdded";
			}
		}
	}
	
/*	@RequestMapping(value = "/login.obj")
	public String redirectToAddAthlete(Model model) throws UserException {
		User user = new User();
		model.addAttribute("user", user);
		return "LoginForm";
	}
*/
	@RequestMapping(value = "/display.obj")
	public String showAllUsers(Model model) throws UserException {
		ulist = userService.getUserList();
		model.addAttribute("elist", ulist);
			return "showAllPage";
	}

	@RequestMapping(value = "/goHome.obj")
	public String goToHome(Model model) {
		return "index";
	}

	@ExceptionHandler(UserException.class)
	public String handleException(UserException e) {
		e.printStackTrace();
		return "athleteException";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		e.printStackTrace();
		return "dataException";
	}

}
