package com.example.attr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;

public class GameInfo {
	public static Map<String, Poker> bitMap;
	public static Map<String, String> colorMap;
	public static Map<String, RoleInfo> roleMap;
	public String[] weekDay;
	public String[] day;
	public String[] month;
	public static boolean new_b;
    public static int width;
    public static float widthScale;
	public static List<Subject> subjectList;
	public static int[] tool_goodness;
    public static int[] tool_neutral;
	public static List<Daoju> daojuList;
	public static List<Work> workList;
	public static List<Department> departmentList;
	public static int record_index;
	public static SharedPreferences sharedPreferences;
	
	private static GameInfo gameInfo;
	public static Bitmap[] number;
	
	public static GameInfo getInstand() {
        if(gameInfo == null) {
            gameInfo = new GameInfo();
            colorMap = new HashMap();
            colorMap.put("red", "#FF0000");
            colorMap.put("green", "#008000");
            colorMap.put("pink", "#FFC0CB");
            colorMap.put("blue", "#0000ff");
        }
        return gameInfo;
    }
	
	public void initGame(Context context) {
		if("".equals(Info.name)){
			Info.name = "李华";
		}
		Info.attrMap = parseAttrInfoByXml(context,0x7f050000);
		Set<String> set = new HashSet<String>();
		set = Info.attrMap.keySet();
		for(String key : set){
			Attribute val = (Attribute) Info.attrMap.get(key);
			val.value = (float)(new Random().nextInt(0xa) + 0x5);
		}
		Info.attrMap.get("体力").value = (float)(new Random().nextInt(0xa) + 0x69);
        Info.attrMap.get("知识").value = 0.0f;
        Info.attrMap.get("实践").value = 0.0f;
        Info.attrMap.get("交际").value = 0.0f;
        Info.attrMap.get("人气").value = 0.0f;
        Info.attrMap.get("政治").value = 0.0f;
        Info.ill_times = 0x0;
        Info.ill = false;
        Info.day = 0x8;
        Info.month = 0x9;
        Info.week = 0x1;
        Info.weekday = 0x1;
        Info.pingjia = false;
        Info.ill_tip = false;
        Info.isnewmonth = false;
        Info.pingjiaed1 = false;
        Info.pingjiaed2 = false;
        Info.pingjiaed3 = false;
        Info.pingjiaed4 = false;
        Info.pingjiaed5 = false;
        Info.shipMap = new HashMap<String, Integer>();
        /*所有属性重写*/
        Info.shipMap.put("工数", Integer.valueOf(0x0));
        Info.shipMap.put("线数", Integer.valueOf(0x0));
        Info.shipMap.put("思修", Integer.valueOf(0x0));
        Info.shipMap.put("体育", Integer.valueOf(0x0));
        Info.shipMap.put("军理", Integer.valueOf(0x0));
        Info.shipMap.put("C语言", Integer.valueOf(0x0));
        Info.shipMap.put("py", Integer.valueOf(0x0));
        Info.shipMap.put("导论", Integer.valueOf(0x0));
        Info.shipMap.put("英语", Integer.valueOf(0x0));
//        Department d = (Department)departmentList.get(Info.department);
//        if(!d.addAttr.equals("\u91d1\u94b1")) {
//            Info.attrMap.get(d.addAttr).value = (Info.attrMap.get(d.addAttr).value + (float)(new Random().nextInt(0x1e) + 0x28));
//        } else {
//            Info.attrMap.get(d.addAttr).value = (Info.attrMap.get(d.addAttr).value + 1000.0f);
//        }
        if("肉多多".equals(Info.name)){
        	Info.attrMap.get("金钱").value = 36000;
        }
        Info.myWorkList = new ArrayList<Integer>();
        Info.myWorkList.add(0xd);
        Info.myWorkList.add(0xe);
        Info.myWorkList.add(0xf);
        Info.myDaojuList = new ArrayList<Integer>();
        
	}
	
	public void init(Context context){
		
	}
	
	private Map<String, Attribute> parseAttrInfoByXml(Context context, int xml) {
		// TODO Auto-generated method stub
		HashMap<String, Attribute> attrMap = new HashMap<String, Attribute>();
		XmlResourceParser xrp = context.getResources().getXml(xml);
		try{
			while(xrp.getEventType() != XmlResourceParser.END_DOCUMENT){
				if(xrp.getEventType() == XmlResourceParser.START_TAG){
					String name = xrp.getName();
					if(name.equals("Image")){
						String attrName = xrp.getAttributeValue(0x0);
						int limitValue = Integer.parseInt(xrp.getAttributeValue(0x1));
						Attribute attr = new Attribute(attrName, 0.0f, limitValue);
						attrMap.put(attr.name, attr);
					}
				}
				else if (xrp.getEventType() == XmlResourceParser.END_TAG) {  
				} else if (xrp.getEventType() == XmlResourceParser.TEXT) {  
				}   
				xrp.next();
			}
		}catch (XmlPullParserException e) {  

		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		return attrMap;
	}
	
}
