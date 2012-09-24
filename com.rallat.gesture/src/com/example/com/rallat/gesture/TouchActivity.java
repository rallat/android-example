package com.example.com.rallat.gesture;

import android.app.Activity;
import android.os.Bundle;

public class TouchActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TouchView view=new TouchView(this);
		setContentView(view);
	}
}
