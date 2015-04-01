package com.example.view;

import com.example.attr.GameInfo;
import com.example.attr.Info;
import com.example.nimei.MainActivity;
import com.example.nimei.RoleActivity;
import com.example.util.Common;
import com.example.util.SaveRecord;

import android.R;
import android.R.style;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RecordGameDialog implements OnClickListener{

	private RoleActivity activity;
	private ImageView backbt;
	private ImageView okbt;
	private Context context;
	private boolean cover;
	private Dialog dialog;
	private TextView[] record;
	private TextView record1;
	private TextView record2;
	private TextView record3;
	private LinearLayout[] recordLayout;
    private LinearLayout recordLayout1;
    private LinearLayout recordLayout2;
    private LinearLayout recordLayout3;
    
    public void RecordGamedialog(Context context) {
        this.context = context;
    }
    
    public void showDialog(boolean cover) {
        this.cover = cover;
        if(dialog == null){
        	dialog = new Dialog(context,0x7f0d0085){
        		
        		public boolean onKeyDown(int keyCode, KeyEvent event) {
                    if(keyCode == 0x4) {
                        dialog.dismiss();
                        return false;
                    }
                    return super.onKeyDown(keyCode, event);
                }
        	};
        	
        }
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(0x7f03001e);
        okbt = (ImageView)dialog.findViewById(0x7f07005f);
        backbt = (ImageView)dialog.findViewById(0x7f070060);
        record1 = (TextView)dialog.findViewById(0x7f07005a);
        record2 = (TextView)dialog.findViewById(0x7f07005c);
        record3 = (TextView)dialog.findViewById(0x7f07005e);
        recordLayout1 = (LinearLayout)dialog.findViewById(0x7f070059);
        recordLayout2 = (LinearLayout)dialog.findViewById(0x7f07005b);
        recordLayout3 = (LinearLayout)dialog.findViewById(0x7f07005d);
        recordLayout = new LinearLayout[] {recordLayout1, recordLayout2, recordLayout3};
        okbt.setOnClickListener(this);
        backbt.setOnClickListener(this);
        recordLayout1.setOnClickListener(this);
        recordLayout2.setOnClickListener(this);
        recordLayout3.setOnClickListener(this);
        record = new TextView[] {record1, record2, record3};
        for(int i=1; i<4; i++){
        	String str = GameInfo.sharedPreferences.getString("" + (i + 0x1), "");
            if("".equals(str)) {
                str = "" + (i + 0x1);
                recordLayout[i].setEnabled(false);
            } else {
                recordLayout[i].setEnabled(true);
            }
            record[i].setText(str);
        }
        dialog.show();
    }
	
    
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case 0x7f07005f:
			if(GameInfo.record_index > 0){
				Common.mediaPlayer1.pause();
	            GameInfo.new_b = false;
	            SaveRecord.getInstand().readRecord();
	            Intent i = new Intent();
	            i.setClass(context, MainActivity.class);
	            context.startActivity(i);
			}
            dialog.dismiss();
            Toast.makeText(context, "\u8bf7\u9009\u62e9\u4e00\u6761\u5b58\u6863", 0x0).show();
			break;
		case 0x7f070060:
			dialog.dismiss();
            break;
		case 0x7f07005a:
			GameInfo.record_index = 0x1;
            recordLayout1.setBackgroundResource(0x7f020080);
            recordLayout2.setBackgroundResource(0x7f02007f);
            recordLayout3.setBackgroundResource(0x7f02007f);
			break;
		case 0x7f07005c:
			GameInfo.record_index = 0x2;
            recordLayout1.setBackgroundResource(0x7f02007f);
            recordLayout2.setBackgroundResource(0x7f020080);
            recordLayout3.setBackgroundResource(0x7f02007f);
			break;
			
		case 0x7f07005e:
			GameInfo.record_index = 0x3;
            recordLayout1.setBackgroundResource(0x7f02007f);
            recordLayout2.setBackgroundResource(0x7f02007f);
            recordLayout3.setBackgroundResource(0x7f020080);
			break;

		default:
			break;
		}
	}

}
