package com.shop.vo;

/**
 * Commodity entity. @author MyEclipse Persistence Tools
 */
public class Commodity extends AbstractCommodity implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Commodity() {
    }

    
    /** full constructor */
    public Commodity(String commodityinfo, Integer quantity) {
        super(commodityinfo, quantity);        
    }
   
}
