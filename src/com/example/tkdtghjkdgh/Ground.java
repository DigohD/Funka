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
	private Random r;
	private Paint p;
	
	public Ground(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		p = new Paint(Color.BLUE);
		rect = new Rect(x, y, width, height);
		spawnLevel();
	}
	
	private void spawnLevel(){
		int x = 10;
		for(int i = 0; i < 50; i++){
			obstacles.add(new Obstacle(x, y+20));
			x += 10;
		}
	}
	
	public void tick(){
		x--;
	}
	
	public void draw(Canvas c){
		c.drawRect(rect, p);
		for(Obstacle o : obstacles)
			c.drawRect(o.getRect(), o.getPaint());
	}

}
