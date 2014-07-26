package com.soloway.banking.sberstarter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentProjectDescr extends Fragment {
	
	private FragmentTabHost mTabHost;
	
	private Fragment fragmentProjectAbout = new FragmentProjectAbout();
    private Fragment fragmentProjectAuthor = new FragmentProjectAuthor();
    private Fragment fragmentProjectDiscuss = new FragmentProjectDiscuss();
    private Fragment fragmentProjectFund = new FragmentProjectFund();
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	        
		 
		 
		 // Inflate the layout for this fragment
	        View V = inflater.inflate(R.layout.fragment_project_descr, container, false);

	        return V;
	    }
	
}
