package com.example.view;

import java.util.ArrayList;
import java.util.List;

import com.example.attr.Info;
import com.example.nimei.MainActivity;
import com.example.nimei.R;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ZhuangtaiDialog implements OnClickListener{

	private TextView weeknum;
	private Context context;
	private Dialog dialog;
	private Button fanhuibt;
	private MainActivity main;
	private List<Integer> mList;
	private ZhuangtaiDialog.MyAdapater myAdapter;
	private int temp;
	
	private GridView zhuangtaiGridView;

	public ZhuangtaiDialog(Context context) {
		this.context = context;
	}

	public void showDialog(Context context){
		if(dialog == null){
			dialog = new Dialog(context, R.style.dimDialog){

				public boolean onKeyDown(int keyCode, KeyEvent event) {
					if(keyCode == 0x4) {
						dialog.dismiss();
						return false;
					}
					return super.onKeyDown(keyCode, event);
				}
			};
			dialog.setCanceledOnTouchOutside(true);
			dialog.setContentView(R.layout.zhuangtai);
			weeknum = (TextView) dialog.findViewById(R.id.weeknum);
			zhuangtaiGridView = (GridView)dialog.findViewById(R.id.zhuantaigridview);
            fanhuibt = (Button)dialog.findViewById(R.id.fhbt);
            fanhuibt.setOnClickListener(this);
            weeknum.setText(Info.week);
            mList = new ArrayList();
            for(int i = 0x0; i <= (Info.attr.length - 0x3); i = i + 0x1){
            	mList.add(Integer.valueOf(i));
            	myAdapter = new ZhuangtaiDialog.MyAdapater(this, context);
                zhuangtaiGridView.setAdapter(myAdapter);
            }
		}
		dialog.show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fhbt:
			dialog.dismiss();
			break;

		default:
			break;
		}
			
	}
	
    class MyAdapater extends BaseAdapter {
        private List<Integer> list;
        private Context mContext;
        
        public MyAdapater(ZhuangtaiDialog p1, Context context) {
            mContext = context;
            list = mList;
        }
        
        public int getCount() {
            return list.size();
        }
        
        public Object getItem(int position) {
            return Integer.valueOf(position);
        }
        
        public long getItemId(int position) {
            return (long)position;
        }
        
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                ZhuangtaiDialog.MyAdapater.ViewHolder holder = new ZhuangtaiDialog.MyAdapater.ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(0x7f03003c, parent);
                holder.attrname = (TextView)convertView.findViewById(0x7f0601b2);
                holder.attrbar = (ProgressBar)convertView.findViewById(0x7f0601b3);
                holder.attrnum = (TextView)convertView.findViewById(0x7f0601b4);
                convertView.setTag(holder);
            } else {
                holder = (ZhuangtaiDialog.MyAdapater.ViewHolder)convertView.getTag();
            }
            holder.attrname.setText("" + holder.attrnum);
            holder.attrbar.setMax((int)Info.attrMap.get(Info.attr[position]).limitValue);
            holder.attrbar.setProgress((int)Info.attrMap.get(Info.attr[position]).value);
            holder.attrnum.setText("" + Info.attrMap.get(Info.attr[position]).value);
            return convertView;
        }
        
        class ViewHolder {
            ProgressBar attrbar;
            TextView attrname;
            TextView attrnum;
        }
        ZhuangtaiDialog.MyAdapater.ViewHolder holder;
    }
    
    class ViewHolder {
        ProgressBar attrbar;
        TextView attrname;
        TextView attrnum;
    }

}
