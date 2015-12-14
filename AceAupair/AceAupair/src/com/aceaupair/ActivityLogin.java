package com.aceaupair;

import com.aceaupair.slidingmenu.HomeActivity;
import com.aceaupair.utility.SavePref;
import com.aceaupair.utility.VolleyApiCall;
import com.aceaupair.utility.YogiUtils;
import com.aceaupair.utility.VolleyApiCall.ApiListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class ActivityLogin extends AppCompatActivity implements
		OnClickListener, ApiListener {
	private static final String TAG = "ActivityLogin";
	YogiUtils yogiUtils;
	SavePref savePref;
	VolleyApiCall volleyApiCall;
	RelativeLayout rl_login, rl_signup;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
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
		rl_login = (RelativeLayout) findViewById(R.id.rl_login);
		rl_signup = (RelativeLayout) findViewById(R.id.rl_signup);
		setListener();
	}

	private void setListener() {
		// TODO Auto-generated method stub
		rl_login.setOnClickListener(this);
		rl_signup.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == rl_login) {
			Intent intent = new Intent(ActivityLogin.this, HomeActivity.class);
			startActivity(intent);
		} else if (v == rl_signup) {
			Intent intent = new Intent(ActivityLogin.this,
					ActivityRegister.class);
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
