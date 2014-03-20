package com.example.tkdtghjkdgh;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Obstacle {
	
	private float x, y;
	private Rect rect;
	private Paint p;
	
	public Obstacle(float x, float y){
		this.x = x;
		this.y = y;
		p = new Paint(Color.RED);
		rect = new Rect((int)x, (int)y, 20, 20);
	}
	
	public void tick(Obstacle o){
		rect.set((int)x, (int) y, 20, 20);	
	}
	
	public void draw(Canvas canvas){
		canvas.drawRect(rect, p);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Rect getRect() {
		return rect;
	}
	
	public Paint getPaint(){
		return p;
	}

	public void setRect(Rect rect) {
		this.rect = rect;
	}

}
