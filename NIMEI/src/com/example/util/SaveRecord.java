package com.example.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.SharedPreferences;

import com.example.attr.GameInfo;
import com.example.attr.Info;

public class SaveRecord {
	public static SaveRecord record;
	
	public static SaveRecord getInstand(){
		if(record == null){
			record = new SaveRecord();
		}
		return record;
	}
	
	public void writeRecord() {
		String title = "\u7b2c" + Info.week + "\u5468" ;
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sDateFormat.format(new Date());
        title = new Date() + date;
        SharedPreferences.Editor editor = Info.sharedPreferences.edit();
        editor.putString("" + GameInfo.record_index, title);
        editor.putString("" + GameInfo.record_index, Info.name);
        editor.putInt("" + GameInfo.record_index, Info.day);
        editor.putInt("" + GameInfo.record_index, Info.month);
        editor.putInt("" + GameInfo.record_index, Info.year);
        editor.putBoolean("" + GameInfo.record_index, Info.ill);
        editor.putInt("" + GameInfo.record_index, Info.ill_times);
        editor.putBoolean("" + GameInfo.record_index, Info.pingjia);
        editor.putBoolean("" + GameInfo.record_index, Info.xianliao);
        editor.putInt("" + GameInfo.record_index, Info.xianliao_times);
        
        editor.commit();
	}
	
	public void readRecord(){
		
	}

}
