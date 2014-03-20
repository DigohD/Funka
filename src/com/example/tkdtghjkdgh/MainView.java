package com.example.tkdtghjkdgh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceView;
import android.view.View;

public class MainView extends View{

	Paint paint = new Paint();

    public MainView(Context context) {
        super(context);
        paint.setColor(Color.RED);
    }

    @Override
    public void onDraw(Canvas canvas) {
            canvas.drawLine(0, 0, 200, 200, paint);
            canvas.drawLine(200, 0, 0, 200, paint);
    }
	
}
