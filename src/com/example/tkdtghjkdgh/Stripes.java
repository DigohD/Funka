package com.example.tkdtghjkdgh;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Stripes {

	int y, x = 2000;

	Random rnd = new Random();
	
	public Stripes(){
		y = rnd.nextInt(800);
	}

	public void tick(){
		x = x - 40;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	
	
}
