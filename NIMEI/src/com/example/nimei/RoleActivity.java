package com.example.nimei;

import com.example.attr.GameInfo;
import com.example.attr.Info;
import com.example.util.SaveRecord;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class RoleActivity extends Activity implements OnClickListener{
	
	private static final String[] d = {"计算机科学与技术","信息安全","生物信息","软件工程","物联网工程"};
	private ImageView btnback;
	private ImageView btnnext;
	private EditText name;
	private Spinner departmentspinner;
	private ArrayAdapter<String> adapter;
	
	private MediaPlayer player;
	
	protected void onCreate(Bundle savedInstanceState) {       
        // TODO Auto-generated method stub       
        super.onCreate(savedInstanceState);       
        setContentView(R.layout.role);
        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        
        btnback = (ImageView)findViewById(R.id.role_backbt);
        btnnext = (ImageView)findViewById(R.id.role_nextbt);
        name = (EditText)findViewById(R.id.nameEt);
        departmentspinner = (Spinner)findViewById(R.id.departmentspinner);
        
        btnback.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, d);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        departmentspinner.setAdapter(adapter);
        departmentspinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "你选择了" + d[arg2], Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        if("".equals(Info.name)){
        	Info.name = "李华";
        }
        
        player = MediaPlayer.create(this, R.raw.bg1);
		player.setLooping(true);
		player.start();
        
	}
	
	protected void onStop() {
		super.onStop();
		player.pause();
	}
	
	protected void onResume() {
		super.onResume();
		if(player != null){
			player.start();
		}
	}
	
	protected void onPause() {
		super.onPause();
		player.pause();
	}
	
	protected void onRestart() {
		super.onRestart();
		if(!player.isPlaying())
			player.start();
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == 4){
			finish();
		}
		return true;
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.role_backbt://back
			finish();
			break;
		case R.id.role_nextbt://next
			Info.name = name.getText().toString();
			for(int i=1; i<4; i++){
				String str = GameInfo.sharedPreferences.getString("record_" + i, "");
				if("".equals(str)){
					GameInfo.record_index = i;
				}
				else break;
			}
			player.pause();
			GameInfo.getInstand().initGame(this);
			SaveRecord.getInstand().writeRecord();
			Intent intent = new Intent(RoleActivity.this,JuqingActivity.class);
			startActivity(intent);
			finish();
			break;
		default:
			break;
		}
	}

}
