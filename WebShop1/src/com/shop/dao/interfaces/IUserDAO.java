package com.shop.dao.interfaces;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.shop.dao.UserDAO;
import com.shop.vo.User;

public interface IUserDAO {
	public void save(User transientInstance);

	public void delete(User persistentInstance);

	public User findById(java.lang.Integer id);

	public List findByExample(User instance);

	public List findByProperty(String propertyName, Object value);

	public List findByUname(Object uname);

	public List findByPassword(Object password);

	public List findByEmail(Object email);

	public List findAll();

	public User merge(User detachedInstance);

	public void attachDirty(User instance);

	public void attachClean(User instance);

}
