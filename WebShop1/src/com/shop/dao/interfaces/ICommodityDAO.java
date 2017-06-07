package com.shop.dao.interfaces;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;

import com.shop.dao.CommodityDAO;
import com.shop.vo.Commodity;

public interface ICommodityDAO{
	public List<Object> findPageByQuery(int pageNo, int pageSize, String hql,
			Map map);
	
	/**
	 * @function 根据查询条件查询记录数的个数
	 * @param hql
	 *            hql查询语句
	 * @param map
	 *            用map封装查询条件
	 * @return 数据库中满足查询条件的数据的条数
	 */
	public int getTotalCount(String hql, Map map);

	public void save(Commodity transientInstance);

	public void delete(Commodity persistentInstance);

	public Commodity findById(java.lang.Integer id);

	public List findByExample(Commodity instance);

	public List findByProperty(String propertyName, Object value);

	public List findByCommodityinfo(Object commodityinfo);

	public List findByQuantity(Object quantity);

	public List findAll();

	public Commodity merge(Commodity detachedInstance);

	public void attachDirty(Commodity instance);

	public void attachClean(Commodity instance);

	public Commodity findByCommodityId(int id);

}
