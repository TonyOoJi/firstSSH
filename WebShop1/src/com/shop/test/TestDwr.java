package com.shop.test;

import java.util.List;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.shop.service.impl.CartService;
import com.shop.service.impl.ServiceManager;
import com.shop.service.impl.UserService;
import com.shop.vo.Cart;
import com.shop.vo.User;


public class TestDwr {
	
	public boolean checkUser(String uname){
		User user = new User();
		user.setUname(uname);
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		ServiceManager serviceManager = (ServiceManager) wac.getBean("ServiceManager");
		UserService userService = (UserService) serviceManager.getUserService();
		User theUser = userService.login(user);
		if(theUser!=null){
			return true;
		}
		return false;
	}
	
	public boolean addToCart(Cart cart){
//		System.out.println(cart);
//		System.out.println(cart.getUserid());
//		System.out.println(cart.getCommodityid());
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		ServiceManager serviceManager = (ServiceManager) wac.getBean("ServiceManager");
		CartService cartService = (CartService) serviceManager.getCartService();
		List list = cartService.findByExample(cart);
		int i =0;//判断下面语句是否执行
		if(list.size()>=1){
			Cart carttemp = (Cart) list.get(0);
			carttemp.setQuantity(carttemp.getQuantity()+1);
			System.out.println(carttemp.getQuantity());
			cartService.updateById(carttemp);
			i++;
		}else {
			cart.setQuantity(1);
			cartService.save(cart);
			i++;
		}
		if(i==1){
			return true;
		}
		return false;
	}

}
