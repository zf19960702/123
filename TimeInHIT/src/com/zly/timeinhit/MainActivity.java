package com.zly.timeinhit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
	CharSequence text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置初始布局并添加适配器
        GridView courseForm = (GridView)findViewById(R.id.courseForm);
        CourseForm course = new CourseForm();
        ArrayAdapter<String>  courseAdapter = new ArrayAdapter<String>(this, R.layout.course, course.getCourseForm());
        courseForm.setAdapter(courseAdapter);
        ListView courseList = (ListView)findViewById(R.id.courseList);
        course.setCourseList();
        ArrayAdapter<String>  courseListAdapter = new ArrayAdapter<String>(this, R.layout.course, course.getCourseList());
        courseList.setAdapter(courseListAdapter);
        Button finishButton = (Button)findViewById(R.id.finishButton);
        //设置监听器
        courseList.setOnItemClickListener(new ItemListClickListener());
        courseForm.setOnItemClickListener(new ItemFormClickListener());
        finishButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    class ItemListClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// TODO Auto-generated method stub
			TextView item = (TextView)arg1;
			text = item.getText();
		}
   }
    
    class ItemFormClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// TODO Auto-generated method stub
			if(arg2<8||arg2%8==0)
				return;
			TextView item = (TextView)arg1;
			if(!item.getText().equals(text))
				item.setText(text);
			else
				item.setText("");
		}
    	
    }
}
