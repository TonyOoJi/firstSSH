package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.shop.dao.interfaces.IUserDAO;
import com.shop.service.IUserService;
import com.shop.vo.User;

public class UserService implements IUserService,ApplicationContextAware{
	private IUserDAO userDao;
	private static ApplicationContext applicationContext;

	public IUserDAO getUserDao() {
		return userDao;
	}


	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}


	@Override
	public User login(User user) {
//		System.out.println("user:"+user);
//		System.out.println("userDAO:"+userDao);
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) this.userDao.findByExample(user);
		if(users!=null && users.size()==1){
			return users.get(0);
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		UserService.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext(){
		checkApplicationContext();
		return applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name){
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz){
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);
	}
	
	private static void checkApplicationContext(){
		if(applicationContext == null){
			throw new IllegalStateException("没有springbean对象");
		}
	}
	
}
