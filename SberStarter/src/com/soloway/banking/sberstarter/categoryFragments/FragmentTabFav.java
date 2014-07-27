package com.soloway.banking.sberstarter.categoryFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.soloway.banking.sberstarter.R;

public class FragmentTabFav extends Fragment {
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	        View V = inflater.inflate(R.layout.tab_fav, container, false);

	        return V;
	    }
}
