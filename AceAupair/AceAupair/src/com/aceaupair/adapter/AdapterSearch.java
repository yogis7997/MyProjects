package com.aceaupair.adapter;

import java.util.ArrayList;

import android.R.integer;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceaupair.R;
import com.aceaupair.holder.HolderSearch;
import com.aceaupair.item.ItemSearch;

public class AdapterSearch extends RecyclerView.Adapter<HolderSearch> {

	Activity activity;
	ArrayList<ItemSearch> arrayList;
	int i;

	public AdapterSearch(FragmentActivity activity,
			ArrayList<ItemSearch> arrayList, int i) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
		this.arrayList = arrayList;
		this.i = i;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public void onBindViewHolder(HolderSearch arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public HolderSearch onCreateViewHolder(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		HolderSearch hc;
		if (i == 0) {
			View v = LayoutInflater.from(arg0.getContext()).inflate(
					R.layout.ad_search, null);
			hc = new HolderSearch(v);
		} else {
			View v = LayoutInflater.from(arg0.getContext()).inflate(
					R.layout.ad_search_family, null);
			hc = new HolderSearch(v);
		}

		return hc;
	}

}
