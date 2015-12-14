package com.aceaupair.fragments.family;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.aceaupair.R;
import com.aceaupair.adapter.AdapterSearch;
import com.aceaupair.item.ItemSearch;

public class FragmentSearch extends Fragment implements OnClickListener {

	Spinner sp_country, sp_region, sp_city;
	private View view;
	String country[] = { "India", "Pakistan", "America" };
	String region[] = { "India", "Pakistan", "America" };
	String city[] = { "India", "Pakistan", "America" };
	ImageView img_country, img_region, img_city;
	TextView tv_center, tv_city, tv_region;
	RecyclerView recyclerView;
	ArrayList<ItemSearch> arrayList;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_search, null);
		initViews();
		return view;
	}

	private void initViews() {
		// TODO Auto-generated method stub
		sp_country = (Spinner) view.findViewById(R.id.sp_country);
		sp_region = (Spinner) view.findViewById(R.id.sp_region);
		sp_city = (Spinner) view.findViewById(R.id.sp_city);
		img_city = (ImageView) view.findViewById(R.id.img_city);
		img_region = (ImageView) view.findViewById(R.id.img_region);
		img_country = (ImageView) view.findViewById(R.id.img_country);
		tv_center = (TextView) view.findViewById(R.id.tv_country);
		tv_city = (TextView) view.findViewById(R.id.tv_city);
		tv_region = (TextView) view.findViewById(R.id.tv_region);
		recyclerView = (RecyclerView) view.findViewById(R.id.rv_search);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		setAdapter();
		img_country.setOnClickListener(this);
		img_city.setOnClickListener(this);
		img_region.setOnClickListener(this);
		sp_country.setAdapter(new ArrayAdapter<String>(getActivity(),
				R.layout.spinner_item, country));
		sp_region.setAdapter(new ArrayAdapter<String>(getActivity(),
				R.layout.spinner_item, country));
		sp_city.setAdapter(new ArrayAdapter<String>(getActivity(),
				R.layout.spinner_item, country));

		sp_country.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				tv_center.setText(country[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

		sp_city.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				tv_city.setText(city[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

		sp_region.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				tv_region.setText(region[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void setAdapter() {
		// TODO Auto-generated method stub
		arrayList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			ItemSearch itemSearch = new ItemSearch();
			itemSearch.setName("hello");

			arrayList.add(itemSearch);
		}

		recyclerView.setAdapter(new AdapterSearch(getActivity(), arrayList,1));
	}

	public void showDropDown(View v) {
		// does something very interesting
		sp_country.performClick();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == img_city) {
			sp_city.performClick();
		} else if (v == img_country) {
			sp_country.performClick();
		} else if (v == img_region) {
			sp_region.performClick();
		}

	}
}
