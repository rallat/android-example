package com.example.com.rallat.mapfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class MapActivity extends com.google.android.maps.MapActivity {
	private final static String TAG = MapActivity.class.getName();

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_maplist);

	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	public void onResume() {

		super.onResume();

	}

	@Override
	public void onPause() {
		super.onPause();
	}

	public void onStart() {
		super.onStart();
	}

	public void onDestroy() {
		super.onDestroy();
	}

	public void onStop() {
		super.onStop();
	}

	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {

		default:

			break;
		}
		return true;
	}

}
