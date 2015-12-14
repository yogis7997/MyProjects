package com.aceaupair.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.provider.SyncStateContract.Constants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aceaupair.R;

public class AdapterSideMenu extends BaseAdapter {

	Activity activity;
	String[] arr;

	public AdapterSideMenu(Activity homeActivity, String[] lvMenuItems) {
		// TODO Auto-generated constructor stub
		activity = homeActivity;
		arr = lvMenuItems;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arr.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.ad_sidelist, null);
		RelativeLayout rl_side_bar = (RelativeLayout) convertView
				.findViewById(R.id.relativeLayout1);
		TextView tv_title = (TextView) convertView.findViewById(R.id.textView1);
		tv_title.setText(arr[position]);

		if (com.aceaupair.utility.Constants._SIDE_BAR_POSITION == position) {
			tv_title.setTextColor(activity.getResources().getColor(
					R.color.text_side_bar));
			rl_side_bar.setVisibility(View.VISIBLE);
		} else {
			tv_title.setTextColor(Color.WHITE);
			rl_side_bar.setVisibility(View.INVISIBLE);
		}
		return convertView;
	}

}
