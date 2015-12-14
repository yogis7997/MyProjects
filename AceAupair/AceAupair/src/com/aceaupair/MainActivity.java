package com.aceaupair;

import com.aceaupair.utility.Constants;
import com.aceaupair.utility.SavePref;
import com.aceaupair.utility.VolleyApiCall;
import com.aceaupair.utility.YogiUtils;
import com.aceaupair.utility.VolleyApiCall.ApiListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements OnClickListener,
		ApiListener {

	RelativeLayout rl_aupair, rl_family;
	private static final String TAG = "MainActivity";
	YogiUtils yogiUtils;
	SavePref savePref;
	// private TextView title;
	VolleyApiCall volleyApiCall;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initObjects();
		initViews();
	}

	private void initObjects() {
		// TODO Auto-generated method stub
		yogiUtils = new YogiUtils(this);
		yogiUtils.setStatusBarColor(findViewById(R.id.status_bar),
				getResources().getColor(R.color.light_blue_color));

		volleyApiCall = new VolleyApiCall(this);

		savePref = new SavePref(this);
	}

	private void initViews() {
		// TODO Auto-generated method stub
		rl_aupair = (RelativeLayout) findViewById(R.id.rl_aupair);
		rl_family = (RelativeLayout) findViewById(R.id.rl_family);
		setListener();
	}

	private void setListener() {
		// TODO Auto-generated method stub
		rl_aupair.setOnClickListener(this);
		rl_family.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (rl_aupair == v) {
			Constants._AUPAIR=true;
			Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
			startActivity(intent);
		} else if (rl_family == v) {
			Constants._AUPAIR=false;
			Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
			startActivity(intent);
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
}
