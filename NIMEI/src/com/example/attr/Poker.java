package com.example.attr;

public class Poker {
	private int height;
    private int horNum;
    private String imagefile;
    private int[] time;
    private int verNum;
    private int width;
    
    public Poker(int width, int height, int horNum, int verNum, String imagefile) {
        this.height = height;
        this.width = width;
        this.horNum = horNum;
        this.verNum = verNum;
        this.imagefile = imagefile;
    }
    
    public String getImagefile() {
        return imagefile;
    }
    
    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getHorNum() {
        return horNum;
    }
    
    public void setHorNum(int horNum) {
        this.horNum = horNum;
    }
    
    public int getVerNum() {
        return verNum;
    }
    
    public void setVerNum(int verNum) {
        this.verNum = verNum;
    }
    
    public int[] getTime() {
        return time;
    }
    
    public void setTime(int[] time) {
        this.time = time;
    }

}
