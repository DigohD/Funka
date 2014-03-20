package com.example.tkdtghjkdgh;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Player {
	
	private float x, y;
	private Rect rect;
	private Paint p;
	private boolean live = true;
	
	public Player(float x, float y, Paint p){
		this.x = x;
		this.y = y;
		this.p = p;
		rect = new Rect((int)x, (int)y, 20, 20);
	}
	
	public void tick(Obstacle o){
		rect.set((int)x, (int) y, 20, 20);
		
		if(rect.intersect(o.getRect()))
			live = false;
	}
	
	public void draw(Canvas canvas){
		canvas.drawRect(rect, p);
	}
	
	public boolean isLive(){
		return live;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setRect(Rect rect) {
		this.rect = rect;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Rect getRect() {
		return rect;
	}

}
