package com.shop.action;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.service.impl.UserService;
import com.shop.vo.User;

public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private UserService userService;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute(){
		User user = new User();
		user.setUname(username);
		user.setPassword(password);
//		System.out.println("user:"+user.getUname());//ok
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		userService = (UserService) wac.getBean("UserService");
		//
		System.out.println("userservice:"+userService);
		
		User theUser = userService.login(user);
		//
		System.out.println("theUser:"+theUser);
		
		if(theUser!=null){
			return SUCCESS;
		}
		return INPUT;
	}
	
	public boolean checkUser(String uname){
		User user = new User();
		user.setUname(uname);
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		userService = (UserService) wac.getBean("UserService");
		//
		System.out.println("userservice:"+userService);
		
		User theUser = userService.login(user);
		//
		System.out.println("theUser:"+theUser);
		
		if(theUser!=null){
			return true;
		}
		return false;
	}
}
