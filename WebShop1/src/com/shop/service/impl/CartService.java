package com.shop.service.impl;

import java.util.List;

import com.shop.dao.interfaces.ICartDAO;
import com.shop.service.ICartService;
import com.shop.vo.Cart;
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

	@Override
	public List findByExample(Cart cart) {
		List list = cartDao.findByExample(cart);
		return list;
	}

	@Override
	public void save(Cart cart) {
		cartDao.save(cart);
	}

	@Override
	public void updateById(Cart cart) {
		cartDao.updateById(cart);
	}
	
}
