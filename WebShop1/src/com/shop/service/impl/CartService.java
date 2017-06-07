package com.shop.service.impl;

import java.util.List;

import com.shop.dao.interfaces.ICartDAO;
import com.shop.service.ICartService;
import com.shop.vo.User;

public class CartService implements ICartService{
	private ICartDAO cartDao;

	public ICartDAO getCartDao() {
		return cartDao;
	}

	public void setCartDao(ICartDAO cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public List findByUser(User user) {
		List list = cartDao.findByUserid(user.getUid());
		return list;
	}
	
}
