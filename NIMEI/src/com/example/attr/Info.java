package com.example.attr;

import java.util.List;
import java.util.Map;

import android.content.SharedPreferences;

public class Info {
	public static Map<String, Attribute> attrMap;
	public static boolean sex;
	public static int day;
	public static int week;
	public static int month;
	public static int year;
	public static int weekday;
	public static int positive;
	public static int morning;
	public static boolean ill;
	public static int ill_times;
	public static boolean ill_tip;
    public static boolean isnewmonth;
    public static int xianliao_times;
    public static Map<String, Integer> shipMap;
    public static List<Integer> myWorkList;
    public static List<Integer> myDaojuList;
    public static String name;
    public static boolean xianliao;
    public static boolean pingjia;
    public static boolean pingjiaed1;
    public static boolean pingjiaed2;
    public static boolean pingjiaed3;
    public static boolean pingjiaed4;
    public static boolean pingjiaed5;
    public static List<Integer> shopdaojuList;
    public static SharedPreferences sharedPreferences;
//    public static int yinshi;
    public static String[] department = new String[] {"计算机科学与技术","软件工程","物联网工程","生物信息","信息安全"};
    public static String[] attr = new String[] {"\u77e5\u8bc6","\u4f53\u529b","\u5a31\u4e50","\u5b9e\u8df5","\u4ea4\u9645","\u653f\u6cbb","\u4eba\u6c14","\u75b2\u52b3","\u5065\u5eb7"};
//    public static int speed = 0x32;
    public static int[] workList = new int[0x32];
    public static boolean[] event_b = new boolean[0x32];

}
