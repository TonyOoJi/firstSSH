package com.shop.action;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.service.impl.ServiceManager;
import com.shop.service.impl.UserService;
import com.shop.vo.User;

public class RegistAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private String repassword;
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	@Override
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	private ServiceManager serviceManager;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ServiceManager getServiceManager() {
		return serviceManager;
	}
	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
	public String execute(){
		System.out.println("registaction:"+user.getUname());
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		serviceManager = (ServiceManager) wac.getBean("ServiceManager");
		userService =(UserService) serviceManager.getUserService();
		System.out.println(userService);
		userService.saveUser(user);
		return SUCCESS;
	}
}
