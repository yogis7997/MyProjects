package com.aceaupair.slidingmenu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aceaupair.R;
import com.aceaupair.adapter.AdapterSideMenu;
import com.aceaupair.fragments.aupair.FragmentMessage;
import com.aceaupair.fragments.aupair.FragmentProfile;
import com.aceaupair.fragments.aupair.FragmentSearch;
import com.aceaupair.slidingmenu.MainLayout.ToggleListener;
import com.aceaupair.utility.Constants;
import com.aceaupair.utility.SavePref;
import com.aceaupair.utility.VolleyApiCall;
import com.aceaupair.utility.VolleyApiCall.ApiListener;
import com.aceaupair.utility.YogiUtils;

public class HomeActivity extends AppCompatActivity implements ApiListener,
		OnClickListener, ToggleListener {

	MainLayout mLayout;
	private ListView lvMenu;
	private String[] lvMenuItems;

	private static final String TAG = null;
	YogiUtils yogiUtils;
	SavePref savePref;
	// private TextView title;
	VolleyApiCall volleyApiCall;
	ImageView img_refresh;
	private Toolbar toolbar;
	private TextView title;
	private ImageView img_toggle;
	AdapterSideMenu adSideMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mLayout = (MainLayout) this.getLayoutInflater().inflate(
				R.layout.activity_home, null);
		mLayout.setToggleListener(this);
		setContentView(mLayout);
		initObjects();
		initToolbar();
		// initStatusBar();

		lvMenuItems = getResources().getStringArray(R.array.menu_items);
		lvMenu = (ListView) findViewById(R.id.menu_listview);
		// lvMenu.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
		// lvMenuItems));

		adSideMenu = new AdapterSideMenu(this, lvMenuItems);
		lvMenu.setAdapter(adSideMenu);
		lvMenu.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				onMenuItemClick(parent, view, position, id);
				Constants._SIDE_BAR_POSITION = position;
			}

		});

		if (Constants._AUPAIR) {
			FragmentManager fm = HomeActivity.this.getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			FragmentProfile fragment = new FragmentProfile();
			ft.add(R.id.activity_main_content_fragment, fragment);
			ft.commit();
		} else {
			FragmentManager fm = HomeActivity.this.getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			com.aceaupair.fragments.family.FragmentProfile fragment = new com.aceaupair.fragments.family.FragmentProfile();
			ft.add(R.id.activity_main_content_fragment, fragment);
			ft.commit();
		}

	}

	private void initObjects() {
		// TODO Auto-generated method stub
		yogiUtils = new YogiUtils(this);
		yogiUtils.setStatusBarColor(findViewById(R.id.status_bar),
				getResources().getColor(R.color.status_color));

		volleyApiCall = new VolleyApiCall(this);

		savePref = new SavePref(this);
	}

	private void initToolbar() {
		// TODO Auto-generated method stub
		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		title = (TextView) toolbar.findViewById(R.id.title);
		img_toggle = (ImageView) toolbar.findViewById(R.id.img_toggle);
		img_toggle.setVisibility(View.VISIBLE);
		img_toggle.setOnClickListener(this);

		title.setText("hello");
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("");
		// getSupportActionBar().setDisplayShowHomeEnabled(true);
		// getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		// final Drawable upArrow = getResources().getDrawable(
		// R.drawable.abc_ic_ab_back_mtrl_am_alpha);
		// upArrow.setColorFilter(getResources().getColor(R.color.toggle_color),
		// PorterDuff.Mode.SRC_ATOP);
		// getSupportActionBar().setHomeAsUpIndicator(upArrow);
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

	public void toggleMenu(View v) {
		mLayout.toggleMenu();
		adSideMenu.notifyDataSetChanged();
	}

	private void onMenuItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		String selectedItem = lvMenuItems[position];
		// String currentItem = tvTitle.getText().toString();
		// if (selectedItem.compareTo(currentItem) == 0) {
		// mLayout.toggleMenu();
		// return;
		// }

		FragmentManager fm = HomeActivity.this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Fragment fragment = null;

		if (Constants._AUPAIR) {
			if (position == 0) {
				fragment = new FragmentProfile();
			} else if (position == 1) {
				fragment = new FragmentMessage();
			} else {
				fragment = new FragmentSearch();
			}
		} else {
			if (position == 0) {
				fragment = new com.aceaupair.fragments.family.FragmentProfile();
			} else if (position == 1) {
				fragment = new FragmentMessage();
			} else {
				fragment = new com.aceaupair.fragments.family.FragmentProfile();
			}
		}

		if (fragment != null) {
			ft.replace(R.id.activity_main_content_fragment, fragment);
			ft.commit();
			// tvTitle.setText(selectedItem);
		}
		mLayout.toggleMenu();
	}

	@SuppressLint("NewApi")
	@Override
	public void onBackPressed() {
		 Log.d("@@@@@@ back stack entry count : ", ""+ getSupportFragmentManager().getBackStackEntryCount());
		if (mLayout.isMenuShown()) {
			mLayout.toggleMenu();
		} else
			

        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {

            // only show dialog while there's back stack entry
//            dialog.show(getSupportFragmentManager(), "ConfirmDialogFragment");
        	Toast.makeText(getApplicationContext(), "back", Toast.LENGTH_SHORT).show();

        } else if (getSupportFragmentManager().getBackStackEntryCount() == 0) {

            // or just go back to main activity
        	getSupportFragmentManager().popBackStack();
            super.onBackPressed();
        }

	}

	@Override
	public void onResponse(String jsonString, int apiCall) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(String error, int apiCall) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == img_toggle) {
			mLayout.toggleMenu();
			adSideMenu.notifyDataSetChanged();
			// toggleMenu(v);
			// mLayout.toggleMenu();
			// adSideMenu = new AdapterSideMenu(this, lvMenuItems);
			// lvMenu.setAdapter(adSideMenu);
			// adSideMenu.notifyDataSetChanged();
		}
	}

	@Override
	public void isToggle(Boolean b) {
		// TODO Auto-generated method stub
		if (!b)
			adSideMenu.notifyDataSetChanged();
	}

}
