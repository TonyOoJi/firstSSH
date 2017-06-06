package com.shop.action;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.service.impl.CommodityService;
import com.shop.service.impl.ServiceManager;
import com.shop.vo.Pager;

public class HomeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private int page;
	private ServiceManager serviceManager;
	
	public ServiceManager getServiceManager() {
		return serviceManager;
	}
	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	 public String getPageList() {
		 	WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			serviceManager = (ServiceManager) wac.getBean("ServiceManager");
	        this.pager = serviceManager.getCommodityService().queryForPage(8, page);
	        return SUCCESS;
	    }
}
