package com.example.tkdtghjkdgh;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

	MainView drawView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        drawView = new MainView(this);
        drawView.setBackgroundColor(Color.BLACK);
        setContentView(drawView);
    }

}
