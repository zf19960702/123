package com.example.nimei;

import com.example.attr.GameInfo;
import com.example.attr.Info;
import com.example.attr.RoleInfo;
import com.example.event.EndEvent;
import com.example.util.Common;
import com.example.view.ImageNumberView;
import com.example.view.SetGameDialog;
import com.example.view.ZhuangtaiDialog;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button zhuangtaiButton;
	public AnimationDrawable changeAnim;
	private TextView nameTextView;
	public LinearLayout dialogLayout;
	public LinearLayout btnLayout;
	private ImageView year;
	private ImageView mon1;
	private ImageView mon2;
	private ImageView day1;
	private ImageView day2;
	private ImageNumberView pilaotxt;
	private ImageNumberView jinqiantxt;
//	private ImageNumberView weektxt;
	private Button shubaoButton;
	private Button xianliaoButton;
	private Button richengButton;
	private Button shezhiButton;
	private Button xiaoyuanButton;
	public ImageView jijie;
    public Bitmap jijie_bit;
	private Bitmap daymap1;
	private Bitmap daymap2;
	private Bitmap monmap1;
    private Bitmap monmap2;
    private SetGameDialog setGamedialog;
	public ImageView npc_icon;
    public TextView npc_name;
    public TextView npc_text;
    public RelativeLayout overLayout;
    public RelativeLayout talkLayout;
    public TextView overtxt;
	private Bitmap[] bitmap;
	private AlphaAnimation talkAnim;
	private ZhuangtaiDialog zhuangtaiDialog;
    public static Boolean isinMainActivity = Boolean.valueOf(true);
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState); 
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		getWindow().setFlags(0x80, 0x80);
		getWindow().setFlags(0x400, 0x400);
		
		findViewById();
		setOnClickListener();
		init();
//		Common.
	}

	private void init() {
		// TODO Auto-generated method stub
		bitmap = new Bitmap[0x7];
		//bitmap[0] = BitmapFactory.decodeResource(getResources(), id);
		talkAnim = new AlphaAnimation(0.0f, 1.0f);
        talkAnim.setDuration(0x1f4);
		pilaotxt.setMyBitmap(GameInfo.number);
        jinqiantxt.setMyBitmap(GameInfo.number);
        zhuangtaiDialog = new ZhuangtaiDialog(this);
        GameInfo.getInstand().roleMap.put("role",new RoleInfo(Info.name, R.drawable.renwu0x1));
        if(GameInfo.new_b) {
            initTalking();
        }
        setText();
	}

	private void setText() {
		// TODO Auto-generated method stub
		
	}

	private void initTalking() {
		// TODO Auto-generated method stub
		talkLayout.setVisibility(0x0);
        btnLayout.setVisibility(0x8);
	}
	
	public void setTalking(RoleInfo info, String content) {
        npc_icon.setImageResource(info.getIcon());
        npc_name.setText(info.getName());
        npc_text.setText(content);
        dialogLayout.startAnimation(talkAnim);
    }
    
    public void setTalking(RoleInfo info, String content, int drawable) {
        npc_icon.setImageResource(drawable);
        npc_name.setText(info.getName());
        npc_text.setText(content);
        dialogLayout.startAnimation(talkAnim);
    }

	private void setOnClickListener() {
		// TODO Auto-generated method stub
		zhuangtaiButton.setOnClickListener(this);
		shubaoButton.setOnClickListener(this);
		xianliaoButton.setOnClickListener(this);
		richengButton.setOnClickListener(this);
		shezhiButton.setOnClickListener(this);
		xiaoyuanButton.setOnClickListener(this);
	}

	private void findViewById() {
		// TODO Auto-generated method stub
		zhuangtaiButton = (Button) findViewById(R.id.zhuantai);
		nameTextView = (TextView) findViewById(R.id.name);
		year = (ImageView) findViewById(R.id.year);
		mon1 = (ImageView) findViewById(R.id.mon1);
		mon2 = (ImageView) findViewById(R.id.mon2);
		day1 = (ImageView) findViewById(R.id.day1);
		day2 = (ImageView) findViewById(R.id.day2);
		pilaotxt = (ImageNumberView) findViewById(R.id.pilao_main);
		jinqiantxt = (ImageNumberView) findViewById(R.id.jinqian_main);
		shubaoButton = (Button) findViewById(R.id.shubaobt);
		xianliaoButton = (Button) findViewById(R.id.xianliaobt);
		richengButton = (Button) findViewById(R.id.richengbt);
		shezhiButton = (Button) findViewById(R.id.shezhibt);
		xiaoyuanButton = (Button) findViewById(R.id.xiaoyuanbt);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.zhuantai:
			zhuangtaiDialog.showDialog(this);
			break;
		case R.id.shubaobt:
			
			break;
		case R.id.xianliaobt:
			
			break;
		case R.id.richengbt:
			
			break;
		case R.id.shezhibt:
			
			break;
		case R.id.xiaoyuanbt:
			
			break;
		default:
			break;
		}
	}

}
