package com.soloway.banking.sberstarter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CategoryFragment extends Fragment {

	private FragmentTabHost tabHost;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	tabHost = new FragmentTabHost(getActivity());
	tabHost.setup(getActivity(), getChildFragmentManager(), R.layout.category_layout);

	Bundle arg1 = new Bundle();
	arg1.putInt("Arg for Frag1", 1);
	tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator("Frag Tab1"),
			ProjectListFragment.class, arg1);

	Bundle arg2 = new Bundle();
	arg2.putInt("Arg for Frag2", 2);
	tabHost.addTab(tabHost.newTabSpec("Tab2").setIndicator("Frag Tab2"),
			ProjectListFragment.class, arg2);

	return tabHost;
	}
}
