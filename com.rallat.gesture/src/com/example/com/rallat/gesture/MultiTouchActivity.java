package com.example.com.rallat.gesture;

import android.app.Activity;
import android.os.Bundle;

public class MultiTouchActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		MultiTouchView view=new MultiTouchView(this);
		setContentView(view);
	}

}
