package com.example.nimei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class JuqingActivity extends Activity{
	
	private TextView juqingEditText;
	private ImageView tiaoguoImageView;

	protected void onCreate(Bundle savedInstanceState) {       
        // TODO Auto-generated method stub       
        super.onCreate(savedInstanceState);       
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.juqing);
        
		juqingEditText = (TextView)findViewById(R.id.juqinget);
		tiaoguoImageView = (ImageView)findViewById(R.id.tiaoguobt);
		
		juqingEditText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(JuqingActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		tiaoguoImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(JuqingActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		Handler myHandler = new Handler(){
			
		};
		
	}
}
