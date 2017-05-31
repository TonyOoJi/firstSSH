package com.shop.service;

import com.shop.vo.User;

public interface IUserService {
	User login(User user);
	void saveUser(User user);
}
