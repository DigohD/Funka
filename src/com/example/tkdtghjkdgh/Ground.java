package com.example.tkdtghjkdgh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Ground {
	
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	private int x, y;
	private Rect rect;
	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	private Random r;
	private Paint p;
	
	public Ground(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		p = new Paint(Color.BLUE);
		rect = new Rect(x, y, x + width, y + height);
		spawnLevel();
	}
	
	private void spawnLevel(){
		int x = 10;
		for(int i = 0; i < 50; i++){
			obstacles.add(new Obstacle(x, y+20));
			x += 1500;
		}
	}
	
	public void tick(){
		for(Obstacle o : obstacles)
			o.tick();
	}
	
	public void draw(Canvas c){
		p.setColor(Color.BLUE);
    	p.setStyle(Paint.Style.FILL);
		c.drawRect(rect, p);
		for(Obstacle o : obstacles){
			p.setColor(Color.GREEN);
	    	p.setStyle(Paint.Style.FILL);
			c.drawRect(o.getRect(), p);
		}
	}

}
