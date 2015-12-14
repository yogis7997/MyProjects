package com.aceaupair.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.aceaupair.R;

public class HolderChat extends RecyclerView.ViewHolder{

	public LinearLayout ll_left;
	public RelativeLayout rl_right;
	public HolderChat(View arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		ll_left = (LinearLayout)arg0.findViewById(R.id.ll_left);
		rl_right = (RelativeLayout)arg0.findViewById(R.id.rl_right);
	}

}
