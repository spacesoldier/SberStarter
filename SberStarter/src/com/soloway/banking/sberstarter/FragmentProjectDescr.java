package com.soloway.banking.sberstarter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentProjectDescr extends Fragment {
	
	private FragmentTabHost mTabHost;
	
	private Fragment fragmentProjectAbout = new FragmentProjectAbout();
    private Fragment fragmentProjectAuthor = new FragmentProjectAuthor();
    private Fragment fragmentProjectDiscuss = new FragmentProjectDiscuss();
    private Fragment fragmentProjectFund = new FragmentProjectFund();
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	     FragmentActivity hoster = (FragmentActivity)this.getActivity();
		 mTabHost = (FragmentTabHost)this.getActivity().findViewById(android.R.id.tabhost);
	        mTabHost.setup(hoster, getChildFragmentManager(), R.id.realtabcontent);

	        mTabHost.addTab(mTabHost.newTabSpec("about").setIndicator(getResources().getString(R.string.tab_new)),
	        		FragmentProjectAbout.class, null);
	        mTabHost.addTab(mTabHost.newTabSpec("author").setIndicator(getResources().getString(R.string.tab_my_project)),
	        		FragmentProjectAuthor.class, null);
	        mTabHost.addTab(mTabHost.newTabSpec("discuss").setIndicator(getResources().getString(R.string.tab_my_deposit)),
	        		FragmentProjectDiscuss.class, null);
	        mTabHost.addTab(mTabHost.newTabSpec("fund").setIndicator(getResources().getString(R.string.tab_my_deposit)),
	        		FragmentProjectFund.class, null);
	        
	        for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++) 
	        {
	            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
	            tv.setTextColor(Color.parseColor("#FFFFFF"));
	        } 
		 
		 // Inflate the layout for this fragment
	        View V = inflater.inflate(R.layout.fragment_project_descr, container, false);

	        return V;
	    }
	
}
