package com.shop.vo;
// default package



/**
 * Cart entity. @author MyEclipse Persistence Tools
 */
public class Cart extends AbstractCart implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Cart() {
    }

    
    /** full constructor */
    public Cart(Integer userid, Integer commodityid, Integer quantity) {
        super(userid, commodityid, quantity);        
    }
   
}
