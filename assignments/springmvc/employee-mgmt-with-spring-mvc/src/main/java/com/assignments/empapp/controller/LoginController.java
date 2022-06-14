package com.assignments.empapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.assignments.empapp.exception.LoginException;
import com.assignments.empapp.model.Login;
import com.assignments.empapp.model.User;
import com.assignments.empapp.service.UserService;

/**
 * Handles requests for the application login page.
 */
@Controller
@SessionAttributes("userName")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {

		return new ModelAndView("login", "command", new Login());
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ExceptionHandler(LoginException.class)
	public ModelAndView authenticate(@ModelAttribute Login user, Model model, HttpSession session) {

		User loginuser = userService.validateUser(user);

		if (null != loginuser) {
			logger.info("Authentication success");

			model.addAttribute("userName", loginuser.getUserName());
			return new ModelAndView("redirect:/employee/list");

		}

		else {
			logger.info("Authentication failed");
			throw new LoginException("Invalid Login or Password");
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/";
	}

}