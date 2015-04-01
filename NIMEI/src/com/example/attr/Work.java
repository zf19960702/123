package com.example.attr;

public class Work {
	public String[] addAttr;
    public String[] lessen;
    public String name;
    public int price;
    public float tired;
    public String type;
    
    public Work(String name, String type, int price, float tired, String[] addAttr, String[] lessen) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.tired = tired;
        this.addAttr = addAttr;
        this.lessen = lessen;
    }

}
