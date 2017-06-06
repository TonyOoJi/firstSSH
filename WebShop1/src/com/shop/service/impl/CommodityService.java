package com.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.shop.dao.CommodityDAO;
import com.shop.dao.interfaces.ICommodityDAO;
import com.shop.service.ICommodityService;
import com.shop.vo.Pager;

public class CommodityService implements ICommodityService {
	private ICommodityDAO commodityDAO;
	public ICommodityDAO getCommodityDAO() {
		return commodityDAO;
	}

	public void setCommodityDAO(ICommodityDAO commodityDAO) {
		this.commodityDAO = commodityDAO;
	}

	private Pager pager = new Pager();
	
	@Override
	public Pager queryForPage(int pageSize, int page) {
		String hql = "select count(*) from Commodity";
		Map<String, String> map = new HashMap<String, String>();
//		map = null;
		int count = commodityDAO.getTotalCount(hql, map);// 总记录数
		int totalPage = pager.countTotalPage(pageSize, count); // 总页数
		int length = pageSize; // 每页记录数
		int currentPage = pager.countCurrentPage(page);//当前页码
		List list = commodityDAO.findPageByQuery(page, length, "from Commodity", map); // 该分页的记录
		// 把分页信息保存到Bean中
		Pager pager = new Pager();
		pager.setPageSize(pageSize);
		pager.setCurrentPage(currentPage);
		pager.setAllRow(count);
		pager.setTotalPage(totalPage);
		pager.setList(list);
		pager.init();
		return pager;
	}

}
