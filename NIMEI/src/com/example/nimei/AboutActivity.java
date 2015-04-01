package com.example.nimei;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class AboutActivity extends Activity{

	private ImageView btnback;
	private EditText textabout;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(0x80, 0x80);
		setContentView(R.layout.activity_about);
		
		btnback = (ImageView)findViewById(R.id.btnback);
		textabout = (EditText)findViewById(R.id.text_about);
		
		btnback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}
	
	
	public boolean onKeyDown(int keyCode,KeyEvent event ){
		if(keyCode == 4){
			finish();
		}
		return true;
	}

}
