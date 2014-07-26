package com.soloway.banking.sberstarter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentProjectAuthor extends Fragment {
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	        View V = inflater.inflate(R.layout.tab_project_author, container, false);

	        return V;
	    }
}
