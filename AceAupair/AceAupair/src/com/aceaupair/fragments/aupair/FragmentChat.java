package com.aceaupair.fragments.aupair;

import java.util.ArrayList;

import com.aceaupair.R;
import com.aceaupair.adapter.AdapterChat;
import com.aceaupair.adapter.AdapterMessage;
import com.aceaupair.item.ItemMessage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentChat extends Fragment{
	private View view;

	RecyclerView recyclerView;

	private ArrayList<ItemMessage> arraylist;
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 view = inflater.inflate(R.layout.fragment_chat, null);
		 initView();
		return view;
	}
	
	private void initView() {
		// TODO Auto-generated method stub
		recyclerView = (RecyclerView) view.findViewById(R.id.rv_message);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		setAdapter();
	}

	private void setAdapter() {
		// TODO Auto-generated method stub
		arraylist = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ItemMessage itemMessage = new ItemMessage();
			itemMessage.setName("hi");
			arraylist.add(itemMessage);

		}
		recyclerView.setAdapter(new AdapterChat(getActivity(), arraylist));
	}
}
