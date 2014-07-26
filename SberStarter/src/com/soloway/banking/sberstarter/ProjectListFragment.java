package com.soloway.banking.sberstarter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProjectListFragment extends Fragment{
	
	private String id;
	
	public ProjectListFragment(String id){
		super();
		this.id = id;
	}
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	              Bundle savedInstanceState) {
	        // TODO Auto-generated method stub
	        View myFragmentView = inflater.inflate(R.layout.projectlistfragment, container, false);
	    

	    
	        return myFragmentView;
	 }
}
