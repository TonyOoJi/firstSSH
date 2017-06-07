package com.shop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.service.impl.ServiceManager;
import com.shop.service.impl.UserService;
import com.shop.vo.User;

public class LoginAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private UserService userService;
	private ServiceManager serviceManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected Map<String, String> cookies;
	protected HttpSession session;
	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

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
		serviceManager = (ServiceManager) wac.getBean("ServiceManager");
		userService = (UserService) serviceManager.getUserService();
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml"); 
//		userService= (UserService)ctx.getBean("UserService");
//		System.out.println("userservice:"+userService);
		User theUser = userService.login(user);
//		System.out.println("theUser:"+theUser);
		if(theUser!=null){
			session.setAttribute("user", theUser);
			return SUCCESS;
		}
		return INPUT;
	}
	
	public boolean checkUser(String uname){
		User user = new User();
		user.setUname(uname);
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		serviceManager = (ServiceManager) wac.getBean("ServiceManager");
		userService = (UserService) serviceManager.getUserService();
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService= (UserService)ctx.getBean("UserService");
//		System.out.println("userservice:"+userService);
		User theUser = userService.login(user);
		if(theUser!=null){
			return true;
		}
		return false;
	}
	
}
