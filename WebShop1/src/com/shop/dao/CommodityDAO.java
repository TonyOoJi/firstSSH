package com.shop.dao;

// default package

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.dao.interfaces.ICommodityDAO;
import com.shop.vo.Commodity;

/**
 * A data access object (DAO) providing persistence and search support for
 * Commodity entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .Commodity
 * @author MyEclipse Persistence Tools
 */

public class CommodityDAO extends HibernateDaoSupport implements ICommodityDAO{
	private static final Log log = LogFactory.getLog(CommodityDAO.class);
	// property constants
	public static final String COMMODITYID ="commodityid";
	public static final String COMMODITYINFO = "commodityinfo";
	public static final String QUANTITY = "quantity";

	protected void initDao() {
		// do nothing
	}

	/**
	 * @function 分页显示符合所有的记录数，将查询结果封装为Pager
	 * @param pageNo
	 *            当前页数
	 * @param pageSize
	 *            每页显示的条数
	 * @param instance
	 *            将查询条件封装为专家Bean
	 * @return 查询结果Pager
	 */
	public List<Object> findPageByQuery(int pageNo, int pageSize, String hql,
			Map map)
	{
		List<Object> result = null;
		try
		{
			Query query = this.getSession().createQuery(hql);

			Iterator it = map.keySet().iterator();
			while (it.hasNext())
			{
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
			}

			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);

			result = query.list();

		} catch (RuntimeException re)
		{
			throw re;
		}
		return result;
	}
	
	/**
	 * @function 根据查询条件查询记录数的个数
	 * @param hql
	 *            hql查询语句
	 * @param map
	 *            用map封装查询条件
	 * @return 数据库中满足查询条件的数据的条数
	 */
	public int getTotalCount(String hql, Map map)
	{
		try
		{
			Query query = this.getSession().createQuery(hql);

			Iterator it = map.keySet().iterator();
			while (it.hasNext())
			{
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
			}

			Integer count = Integer.parseInt(query.list().get(0).toString());
			return count;
		} catch (RuntimeException re)
		{
			throw re;
		}

	}

	public void save(Commodity transientInstance) {
		log.debug("saving Commodity instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Commodity persistentInstance) {
		log.debug("deleting Commodity instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Commodity findById(java.lang.Integer id) {
		log.debug("getting Commodity instance with id: " + id);
		try {
			Commodity instance = (Commodity) getHibernateTemplate().get(
					"Commodity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Commodity instance) {
		log.debug("finding Commodity instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Commodity instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Commodity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Commodity findByCommodityId(int id){
		List list = findByProperty(COMMODITYID, id);
		Commodity commodity = (Commodity) (list.size()==1?list.get(0):null);
		return commodity;
	}

	public List findByCommodityinfo(Object commodityinfo) {
		return findByProperty(COMMODITYINFO, commodityinfo);
	}

	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List findAll() {
		log.debug("finding all Commodity instances");
		try {
			String queryString = "from Commodity";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commodity merge(Commodity detachedInstance) {
		log.debug("merging Commodity instance");
		try {
			Commodity result = (Commodity) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commodity instance) {
		log.debug("attaching dirty Commodity instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commodity instance) {
		log.debug("attaching clean Commodity instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CommodityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CommodityDAO) ctx.getBean("CommodityDAO");
	}
}