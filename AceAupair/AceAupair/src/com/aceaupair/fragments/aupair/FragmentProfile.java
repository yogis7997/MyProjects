package com.aceaupair.fragments.aupair;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceaupair.R;

public class FragmentProfile extends Fragment {
	private TabLayout tabLayout;
	private ViewPager viewPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile, null);
		viewPager = (ViewPager) view.findViewById(R.id.viewpager);
		setupViewPager(viewPager);

		tabLayout = (TabLayout) view.findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(viewPager);
		return view;
	}

	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity()
				.getSupportFragmentManager());
			adapter.addFragment(new OneFragment(), "My Service");
			adapter.addFragment(new TwoFragment(), "LifeStyle");
			adapter.addFragment(new ThreeFragment(), "Introduction");
			adapter.addFragment(new ThreeFragment(), "Availability Schedule");

		viewPager.setAdapter(adapter);
	}

	class ViewPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> mFragmentList = new ArrayList<>();
		private final List<String> mFragmentTitleList = new ArrayList<>();

		public ViewPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragmentList.get(position);
		}

		@Override
		public int getCount() {
			return mFragmentList.size();
		}

		public void addFragment(Fragment fragment, String title) {
			mFragmentList.add(fragment);
			mFragmentTitleList.add(title);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mFragmentTitleList.get(position);
		}
	}
}
