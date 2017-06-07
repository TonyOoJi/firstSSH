package com.shop.dao.interfaces;

import java.util.List;

import com.shop.vo.Cart;

public interface ICartDAO {
	public void save(Cart transientInstance);

	public void delete(Cart persistentInstance);

	public Cart findById(java.lang.Integer id);

	public List findByExample(Cart instance);

	public List findByProperty(String propertyName, Object value);

	public List findByUserid(Object userid);

	public List findByCommodityid(Object commodityid);

	public List findByQuantity(Object quantity);

	public List findAll();

	public Cart merge(Cart detachedInstance);

	public void attachDirty(Cart instance);

	public void attachClean(Cart instance);
	
	public void updateById(Cart cart);
}
