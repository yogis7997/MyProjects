package com.aceaupair;

import com.aceaupair.utility.SavePref;
import com.aceaupair.utility.VolleyApiCall;
import com.aceaupair.utility.VolleyApiCall.ApiListener;
import com.aceaupair.utility.YogiUtils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivityRegister extends AppCompatActivity implements ApiListener,
		OnClickListener {
	private static final String TAG = "ActivityRegister";
	YogiUtils yogiUtils;
	SavePref savePref;
	// private TextView title;
	VolleyApiCall volleyApiCall;
	RelativeLayout rl_continue, rl_back;
	LinearLayout ll_continue;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initObjects();
		initViews();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		rl_continue = (RelativeLayout) findViewById(R.id.rl_continue);
		rl_back = (RelativeLayout) findViewById(R.id.rl_back);
		ll_continue = (LinearLayout) findViewById(R.id.ll_continue);
		setListener();
	}

	private void setListener() {
		// TODO Auto-generated method stub
		rl_continue.setOnClickListener(this);
		rl_back.setOnClickListener(this);

	}

	private void initObjects() {
		// TODO Auto-generated method stub
		yogiUtils = new YogiUtils(this);
		yogiUtils.setStatusBarColor(findViewById(R.id.status_bar),
				getResources().getColor(R.color.light_blue_color));

		volleyApiCall = new VolleyApiCall(this);

		savePref = new SavePref(this);
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
		if (v == rl_continue) {
			ll_continue.setVisibility(View.VISIBLE);
		}else if(rl_back==v){
			ll_continue.setVisibility(View.GONE);
		}
	}

}
