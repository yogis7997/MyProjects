package com.aceaupair.slidingtab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceaupair.R;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab1 extends Fragment  {

	private static final String TAG = "Tab1";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_layout2,container,false);
//        callApi = new CallApi(this);
//        callApi.makeJsonObjReq(API.GET_ALL_CATEGORIES);
        return v;
    }
   
    
    
   
}
