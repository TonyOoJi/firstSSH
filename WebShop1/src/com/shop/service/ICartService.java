package com.shop.service;

import java.util.List;

import com.shop.vo.Cart;
import com.shop.vo.User;

public interface ICartService {
	public List findByUser(User user);
	public List findByExample(Cart cart);
	public void save(Cart cart);
	public void updateById(Cart cart);
}
