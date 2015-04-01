package com.example.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ImageNumberView extends View{
	private Bitmap[] myBitmap;
	private String[] numbers;
	private Paint paint;
	private int layoutX = 0x0;
	private int layoutY = 0x0;

	public ImageNumberView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
	}
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(numbers != null){
			for(int i=0x1; i<=numbers.length; i++){
				Bitmap bit = null;
		        if((numbers[i].equals("+")) || (numbers[i].equals("-")) 
		        		|| (numbers[i].equals("*")) || (numbers[i].equals("/"))) {
		            if(myBitmap.length > 0xa) {
		                bit = myBitmap[0xa];
		            }
		        } else {
		            bit = myBitmap[Integer.valueOf(numbers[i]).intValue()];
		        }
		        try {
		            canvas.drawBitmap(bit, (float)(((i - 0x1) * myBitmap[0x0].getWidth()) +
		            		((myBitmap[0x0].getWidth() - bit.getWidth()) / 0x2)), 0.0f, paint);
		        } catch(Exception e) {
		        	
		        }
			}
		}
	}
	
	public void setText(String number) {
        numbers = splitStr(number);
        postInvalidate();
    }
    
    public String[] splitStr(String str) {
        return str.split("");
    }
	
	public void setLayoutX(int layoutX) {
        this.layoutX = layoutX;
    }
    
    public int getLayoutX() {
        return layoutX;
    }
    
    public void setLayoutY(int layoutY) {
        this.layoutY = layoutY;
    }
    
    public int getLayoutY() {
        return layoutY;
    }
    
    public void setMyBitmap(Bitmap[] myBitmap) {
        this.myBitmap = myBitmap;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(numbers != null) {
            setMeasuredDimension(
            		(myBitmap[0x0].getWidth() * (numbers.length - 0x1)), myBitmap[0x0].getHeight());
            return;
        }
        setMeasuredDimension(0x0, 0x0);
    }
    
    
}
