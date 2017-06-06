package com.shop.vo;
// default package



/**
 * AbstractCommodity entity provides the base persistence definition of the Commodity entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCommodity  implements java.io.Serializable {


    // Fields    

     private Integer commodityid;
     private String commodityinfo;
     private Integer quantity;


    // Constructors

    /** default constructor */
    public AbstractCommodity() {
    }

    
    /** full constructor */
    public AbstractCommodity(String commodityinfo, Integer quantity) {
        this.commodityinfo = commodityinfo;
        this.quantity = quantity;
    }

   
    // Property accessors

    public Integer getCommodityid() {
        return this.commodityid;
    }
    
    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public String getCommodityinfo() {
        return this.commodityinfo;
    }
    
    public void setCommodityinfo(String commodityinfo) {
        this.commodityinfo = commodityinfo;
    }

    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
   








}