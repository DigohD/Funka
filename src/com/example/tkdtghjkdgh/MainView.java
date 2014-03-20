package com.example.tkdtghjkdgh;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

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
	
	ArrayList<Stripes> stripes = new ArrayList<Stripes>();
	
	Semaphore s = new Semaphore(1);
	
	boolean jump;
	int jumpStacks;
	
	float cX, cY;
	
    public MainView(Context context){
        super(context);
        paint.setColor(Color.RED);
        
        cX = 250;
        cY = 600;
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(cX-00, cY-100, cX+50, cY+100, paint);
        canvas.drawLine(cX+50, cY-100, cX-50, cY+100, paint);
        
        try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(Stripes x : stripes){
        	paint.setColor(Color.WHITE);
    		canvas.drawLine(x.getX(), x.getY(), x.getX() + 100, x.getY(), paint);
    	}
        s.release();
    }
	
    @Override
	    public boolean onTouchEvent(MotionEvent event) {
	    float eventX = event.getX();
	    float eventY = event.getY();
	
	    if(event.getAction() == event.ACTION_DOWN){
	    	jump = true;
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
	    }
      
    	// Schedules a repaint.
    	invalidate();
    	return true;
    }
    
    public void tick(){
    	if(jump)
    		jump();
    	
    	try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(rnd.nextInt(2) == 0)
    		stripes.add(new Stripes());
    	
    	for(Stripes x : stripes)
    		x.tick();
    	s.release();
    }
    
    private void jump(){
    	jumpStacks++;
    	if(jumpStacks < 15)
    		cY -= 16;
    	else if(jumpStacks >= 15 && jumpStacks < 29)
    		cY += 16;
    	else if(jumpStacks >= 29){
    		jump = false;
    		jumpStacks = 0;
    	}
    }
    
}
