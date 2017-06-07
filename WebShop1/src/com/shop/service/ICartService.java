package com.shop.service;

import java.util.List;

import com.shop.vo.User;

public interface ICartService {
	public List findByUser(User user);
}
