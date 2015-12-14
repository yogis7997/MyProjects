package com.aceaupair.adapter;

import java.util.ArrayList;

import com.aceaupair.R;
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

public class AdapterMessage extends RecyclerView.Adapter<HolderMessage> {

	ArrayList<ItemMessage> arrayList;
	Activity activity;

	public AdapterMessage(FragmentActivity activity,
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
	public void onBindViewHolder(HolderMessage arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public HolderMessage onCreateViewHolder(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(arg0.getContext()).inflate(R.layout.ad_message, null);
		HolderMessage hm = new HolderMessage(v);
		return hm;
	}

}
