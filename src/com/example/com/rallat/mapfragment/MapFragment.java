package com.example.com.rallat.mapfragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

public class MapFragment extends ActivityHostFragment {
	Class<? extends Activity> mapActivity=MapActivityFragment.class;
	Bundle extras = new Bundle();

	public static Fragment instantiate(Context context, String fname,
			Class<? extends Activity> mapActivity, Bundle extras) {
		MapFragment fragment = (MapFragment) MapFragment.instantiate(context,
				fname);
		fragment.mapActivity = mapActivity;
		fragment.extras = extras;
		return fragment;

	}

	public static Fragment instantiate(Context context, String fname,
			Class<? extends Activity> mapActivity) {
		MapFragment fragment = (MapFragment) MapFragment.instantiate(context,
				fname);
		fragment.mapActivity = mapActivity;
		fragment.extras = new Bundle();
		return fragment;

	}

	@Override
	protected Class<? extends Activity> getActivityClass() {
		return mapActivity;
	}

	@Override
	protected Bundle getExtras() {

		return extras;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		return true;
	}

}
