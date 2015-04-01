package com.example.attr;

public class RoleInfo {
	private int icon;
	private String name;
	
	public RoleInfo(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public int getIcon() {
        return icon;
    }
    
    public void setIcon(int icon) {
    	this.icon = icon;
    }

}
