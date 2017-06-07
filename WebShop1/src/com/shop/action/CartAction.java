package com.shop.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.jboss.weld.logging.messages.ServletMessage;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.service.impl.ServiceManager;
import com.shop.vo.Cart;
import com.shop.vo.Commodity;
import com.shop.vo.User;

public class CartAction extends ActionSupport implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	private List cartList;
	private List<Commodity> commodityList = new ArrayList<Commodity>();

	public List<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<Commodity> commodityList) {
		this.commodityList = commodityList;
	}

	public List getCartList() {
		return cartList;
	}

	public void setCartList(List cartList) {
		this.cartList = cartList;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public String execute() {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			WebApplicationContext wac = ContextLoader
					.getCurrentWebApplicationContext();
			serviceManager = (ServiceManager) wac.getBean("ServiceManager");
			cartList = serviceManager.getCartService().findByUser(user);
			//通过id查询出cartlist中所有cart的commodity的info
			commodityList.clear();
			for(int i=0; i<cartList.size();i++){
				//清空
				int id =((Cart)cartList.get(i)).getCommodityid();
//				System.out.println((Cart)cartList.get(i));
//				System.out.println(id);
				Commodity commodity = serviceManager.getCommodityService().findById(id);
				commodityList.add(commodity);
//				System.out.println(commodity.getCommodityinfo());
			}
//			for(Commodity co : commodityList){
//				System.out.println(co.getCommodityinfo());
//			}
			return SUCCESS;
		}
		// System.out.println(user.getUid());
		// String userid = request.getParameter("userid");
		// int uid;
		// if(userid != null){
		// uid = Integer.parseInt(userid);
		// }
		// System.out.println(uid);
		return INPUT;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
