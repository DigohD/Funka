package com.example.tkdtghjkdgh;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

import android.R.style;
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
	
	Player player;
	
	Ground g;
	
	int points = 0;
	
	float cX = 200, cY = 500;
	
    public MainView(Context context){
        super(context);
        paint.setColor(Color.RED);
        
        g = new Ground(0, 650, 2000, 200);
        player = new Player(cX, cY, paint);
    }

    @Override
    public void onDraw(Canvas canvas) {
    	// x 1920
    	// y 885
    	
    	float newWidth = canvas.getWidth();
    	float newHeight = canvas.getHeight();
    	
    	float finalWidth = newWidth / 1920;
    	float finalHeight = newHeight / 885;
    	
    	canvas.scale(finalWidth, finalHeight);
    	
    	try {
			s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        for(Stripes x : stripes){
        	paint.setColor(Color.WHITE);
    		canvas.drawLine(x.getX(), x.getY(), x.getX() + 100, x.getY(), paint);
    	}
        s.release();
    	
    	g.draw(canvas);
    	
    	paint.setColor(Color.RED);
    	paint.setStyle(Paint.Style.FILL);
    	canvas.drawRect(player.getRect(), paint);
    	
    	paint.setColor(Color.WHITE);
    	paint.setStyle(Paint.Style.FILL);
    	paint.setTextScaleX(3);
    	paint.setTextSize(50);
    	canvas.drawText("Score: " + points, 40, 80, paint);
    	
    	
        
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
    	
    	for(int i = 0; i < g.getObstacles().size(); i++){
    		player.collision(g.getObstacles().get(i));
    		if(!player.isLive()) System.out.println("Collision");
    			
    		
    	}
    	
    	g.tick();
    	
    	
    	player.tick();
    	
    	points++;
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
    	player.setX(cX);
    	player.setY(cY);
    }
    
}
