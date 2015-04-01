package com.example.nimei;

import com.example.view.RecordGameDialog;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;

public class MenuActivity extends ActionBarActivity implements OnClickListener{

	private ImageView btnAbout;
	private ImageView btnNewGame;
	private ImageView btnOldGame;
	
	private RecordGameDialog recordGameDialog;
	private MediaPlayer player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menu);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(0x80, 0x80);
		btnAbout = (ImageView) findViewById(R.id.btnabout);
		btnNewGame = (ImageView) findViewById(R.id.btnnewgame);
		btnOldGame = (ImageView) findViewById(R.id.btnoldgame);
		
		btnAbout.setOnClickListener(this);
		btnNewGame.setOnClickListener(this);
		btnOldGame.setOnClickListener(this);
		
		player = MediaPlayer.create(this, R.raw.bg1);
		player.setLooping(true);
		player.start();
		
	}
	
	protected void onPause() {
		super.onPause();
		player.pause();
	}
	
	protected void onResume(){
		super.onResume();
		player.start();
	}
	
	protected void onStop() {
		super.onStop();
		player.pause();
	}
	
	protected void onRestart() {
		super.onRestart();
		player.start();
	}
	
	protected void onDestory(){
		super.onDestroy();
		player.stop();
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
		case R.id.btnabout:
			Intent i = new Intent(MenuActivity.this,AboutActivity.class);
			startActivity(i);
			break;
		case R.id.btnnewgame:
			Intent ii = new Intent(MenuActivity.this,RoleActivity.class);
			startActivity(ii);
			break;
		case R.id.btnoldgame:
			recordGameDialog.showDialog(true);
			break;
		default:
			break;
		}
	}


}
