package com.aceaupair.adapter;

import java.util.ArrayList;

import com.aceaupair.R;
import com.aceaupair.holder.HolderChat;
import com.aceaupair.holder.HolderMessage;
import com.aceaupair.item.ItemMessage;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdapterChat extends RecyclerView.Adapter<HolderChat> {

	ArrayList<ItemMessage> arrayList;
	Activity activity;

	public AdapterChat(FragmentActivity activity,
			ArrayList<ItemMessage> arraylist) {
		// TODO Auto-generated constructor stub
		this.arrayList = arraylist;
		this.activity = activity;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public void onBindViewHolder(HolderChat arg0, int arg1) {
		// TODO Auto-generated method stub
		if (arg1 % 2 == 0) {
			arg0.ll_left.setVisibility(View.VISIBLE);
		} else {
			arg0.rl_right.setVisibility(View.GONE);
		}

	}

	@Override
	public HolderChat onCreateViewHolder(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(arg0.getContext()).inflate(
				R.layout.ad_chat, null);
		HolderChat hc = new HolderChat(v);
		return hc;
	}

}
