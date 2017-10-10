package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import classes.User;
import dao.UsersDao;

@Controller
public class DefaultController {
	
	@Autowired
	private UsersDao usersDao;
	
	@RequestMapping(value="/")
	public String showWelcomePage() {
		
		return "welcome";
	}
	@RequestMapping(value="/login")

	public String login() {
		return "login";
	}
	@RequestMapping(value="/newaccount")
	public String register() {
		return "register";
	}
	@RequestMapping(value="/search")
	public String search() {
		return "search";
	}
	@RequestMapping(value="/createaccount")
	public String createAccount(User user) {
		user.setAuthority("admin");
		user.setEnabled(true);
		
		usersDao.create(user);
		
		return "accountcreated";
	}
	@RequestMapping(value="/controlPage")
	public String showcontrolpage(User user) {
		
		return "controlpage";
	}
	@RequestMapping(value="/loggedout")
	public String showLoggedOutPage(User user) {
		
		
		return "loggedout";
	}
	
}
