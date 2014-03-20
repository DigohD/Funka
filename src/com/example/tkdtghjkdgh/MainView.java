package com.example.tkdtghjkdgh;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class MainView extends View{

	Paint paint = new Paint();
	Random rnd = new Random();
	
	int cX, cY;
	
    public MainView(Context context) {
        super(context);
        paint.setColor(Color.RED);
    }

    @Override
    public void onDraw(Canvas canvas) {
            canvas.drawLine(cX-100, cY-100, cX+100, cY+100, paint);
            canvas.drawLine(cX+100, cY-100, cX-100, cY+100, paint);
    }
	
    @Override
	    public boolean onTouchEvent(MotionEvent event) {
	    float eventX = event.getX();
	    float eventY = event.getY();
	
	    if(event.getAction() == event.ACTION_DOWN){
	    	cX = (int) eventX;
	    	cY = (int) eventY;
		    switch(rnd.nextInt(5)){
		    	case 0:
		    		paint.setColor(Color.BLUE);
		    		break;
		    	case 1:
		    		paint.setColor(Color.GREEN);
		    		break;
		    	case 2:
		    		paint.setColor(Color.WHITE);
		    		break;
		    	case 3:
		    		paint.setColor(Color.YELLOW);
		    		break;
		    	case 4:
		    		paint.setColor(Color.RED);
		    		break;
		    }
	    }else if(event.getAction() == event.ACTION_MOVE){
	    	cX = (int) eventX;
	    	cY = (int) eventY;
	    }
      
    	// Schedules a repaint.
    	invalidate();
    	return true;
    }
    
}
