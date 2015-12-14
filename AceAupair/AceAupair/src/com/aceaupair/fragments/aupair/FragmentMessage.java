package com.aceaupair.fragments.aupair;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aceaupair.R;
import com.aceaupair.adapter.AdapterMessage;
import com.aceaupair.fragments.family.OnBackPressListener;
import com.aceaupair.fragments.family.RootFragment;
import com.aceaupair.item.ItemMessage;

public class FragmentMessage extends RootFragment {

	private View v;

	RecyclerView recyclerView;

	private ArrayList<ItemMessage> arraylist;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.fragment_message, null);
		initView();

		return v;
	}

	private void initView() {
		// TODO Auto-generated method stub
		recyclerView = (RecyclerView) v.findViewById(R.id.rv_message);
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
		recyclerView.setAdapter(new AdapterMessage(getActivity(), arraylist));

		recyclerView.addOnItemTouchListener(new RecyclerTouchListener(
				getActivity(), recyclerView, new ClickListener() {
					@Override
					public void onClick(View view, int position) {

						Toast.makeText(getActivity(), "hello ",
								Toast.LENGTH_SHORT).show();
						FragmentChat a2Fragment = new FragmentChat();
						FragmentTransaction transaction = getChildFragmentManager()
								.beginTransaction();

						// Store the Fragment in stack
						transaction.addToBackStack("my_fragment");
						transaction.replace(R.id.fragment_mainLayout,
								a2Fragment).commit();
					}

					@Override
					public void onLongClick(View view, int position) {

					}
				}));
	}

	private void enterNextFragment() {
		FragmentChat a2Fragment = new FragmentChat();
		FragmentTransaction transaction = getChildFragmentManager()
				.beginTransaction();

		// Store the Fragment in stack
		transaction.addToBackStack(null);
		transaction.replace(R.id.fragment_mainLayout, a2Fragment).commit();
	}

	public static interface ClickListener {
		public void onClick(View view, int position);

		public void onLongClick(View view, int position);
	}

	static class RecyclerTouchListener implements
			RecyclerView.OnItemTouchListener {

		private GestureDetector gestureDetector;
		private ClickListener clickListener;

		public RecyclerTouchListener(Context context,
				final RecyclerView recyclerView,
				final ClickListener clickListener) {
			this.clickListener = clickListener;
			gestureDetector = new GestureDetector(context,
					new GestureDetector.SimpleOnGestureListener() {
						@Override
						public boolean onSingleTapUp(MotionEvent e) {
							return true;
						}

						@Override
						public void onLongPress(MotionEvent e) {
							View child = recyclerView.findChildViewUnder(
									e.getX(), e.getY());
							if (child != null && clickListener != null) {
								clickListener.onLongClick(child,
										recyclerView.getChildPosition(child));
							}
						}
					});
		}

		@Override
		public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

			View child = rv.findChildViewUnder(e.getX(), e.getY());
			if (child != null && clickListener != null
					&& gestureDetector.onTouchEvent(e)) {
				clickListener.onClick(child, rv.getChildPosition(child));
			}
			return false;
		}

		@Override
		public void onTouchEvent(RecyclerView rv, MotionEvent e) {
		}

		@Override
		public void onRequestDisallowInterceptTouchEvent(boolean arg0) {
			// TODO Auto-generated method stub

		}
	}
	
	
//	  public boolean onBackPressed() {
//	        // currently visible tab Fragment
//	        OnBackPressListener currentFragment = (OnBackPressListener) adapter.getRegisteredFragment(pager.getCurrentItem());
//
//	        if (currentFragment != null) {
//	            // lets see if the currentFragment or any of its childFragment can handle onBackPressed
//	            return currentFragment.onBackPressed();
//	        }
//
//	        // this Fragment couldn't handle the onBackPressed call
//	        return false;
//	    }

}
