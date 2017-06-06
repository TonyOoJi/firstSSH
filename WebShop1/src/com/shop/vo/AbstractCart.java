package com.shop.vo;
// default package



/**
 * AbstractCart entity provides the base persistence definition of the Cart entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCart  implements java.io.Serializable {


    // Fields    

     private Integer cartid;
     private Integer userid;
     private Integer commodityid;
     private Integer quantity;


    // Constructors

    /** default constructor */
    public AbstractCart() {
    }

    
    /** full constructor */
    public AbstractCart(Integer userid, Integer commodityid, Integer quantity) {
        this.userid = userid;
        this.commodityid = commodityid;
        this.quantity = quantity;
    }

   
    // Property accessors

    public Integer getCartid() {
        return this.cartid;
    }
    
    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCommodityid() {
        return this.commodityid;
    }
    
    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
   








}