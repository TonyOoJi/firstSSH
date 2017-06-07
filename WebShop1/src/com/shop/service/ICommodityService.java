package com.shop.service;

import com.shop.vo.Commodity;
import com.shop.vo.Pager;

public interface ICommodityService {
	public Pager queryForPage(int pageSize, int page);
	public Commodity findById(int id);

}
