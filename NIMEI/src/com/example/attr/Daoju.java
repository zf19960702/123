package com.example.attr;

import java.util.Map;

public class Daoju {
	public String add;
	public Map<String, Integer> daojuMap;
	public String drawable;
	public String name;
    public int price;
    public String shuo;
    public String shuoming;
    
    public Daoju(String name, int price, String shuoming, String shuo,
    		Map<String, Integer> daojuMap, String add, String drawable) {
    	this.name = name;
    	this.price = price;
    	this.shuoming = shuoming;
    	this.shuo = shuo;
    	this.add = add;
    	this.drawable = drawable;
    	this.daojuMap = daojuMap;
    }

}
