package com.example.com.rallat.mapfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		getSupportActionBar().addTab(
				getTab(new TabListener<MapFragment>(this, MapFragment.class
						.getName(), MapFragment.class), "Mapa1"));
		getSupportActionBar().addTab(
				getTab(new TabListener<OtherFragment>(this, OtherFragment.class
						.getName(), OtherFragment.class), "Other"));

		getSupportActionBar().setSelectedNavigationItem(0);

	}

	private Tab getTab(TabListener listener, String title) {
		ActionBar.Tab tab = getSupportActionBar().newTab();
		tab.setTabListener(listener);
		tab.setText(title);
		return tab;
	}

	public class TabListener<T extends Fragment> implements
			ActionBar.TabListener {
		private final SherlockFragmentActivity mActivity;
		private final String mTag;
		private final Class<T> mClass;
		private final Bundle mArgs;
		private Fragment mFragment;

		public TabListener(SherlockFragmentActivity activity, String tag,
				Class<T> clz) {
			this(activity, tag, clz, null);
		}

		public TabListener(SherlockFragmentActivity activity, String tag,
				Class<T> clz, Bundle args) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
			mArgs = args;

			// Check to see if we already have a fragment for this tab, probably
			// from a previously saved state. If so, deactivate it, because our
			// initial state is that a tab isn't shown.
			mFragment = mActivity.getSupportFragmentManager()
					.findFragmentByTag(tag);
			if (mFragment != null && !mFragment.isDetached()) {
				FragmentTransaction ft = mActivity.getSupportFragmentManager()
						.beginTransaction();
				ft.detach(mFragment);
				ft.commit();
			}
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {

			if (mFragment == null) {
				if (mClass.equals(MapFragment.class)) {
					mFragment = MapFragment.instantiate(mActivity,
							mClass.getName(), MapActivityFragment.class);

				} else {
					mFragment = Fragment.instantiate(mActivity,
							mClass.getName(), mArgs);
				}
				ft.add(android.R.id.content, mFragment, mTag);

			} else {
				ft.attach(mFragment);
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (mFragment != null) {
				ft.detach(mFragment);
			}

		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {

		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
}
