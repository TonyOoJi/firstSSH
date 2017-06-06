package com.shop.service.impl;

import com.shop.dao.interfaces.ICartDAO;
import com.shop.service.ICartService;

public class CartService implements ICartService{
	private ICartDAO cartDao;

	public ICartDAO getCartDao() {
		return cartDao;
	}

	public void setCartDao(ICartDAO cartDao) {
		this.cartDao = cartDao;
	}
	
}
