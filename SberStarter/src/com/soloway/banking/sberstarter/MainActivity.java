package com.soloway.banking.sberstarter;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.soloway.banking.sberstarter.categoryFragments.FragmentTabAll;
import com.soloway.banking.sberstarter.categoryFragments.FragmentTabFav;
import com.soloway.banking.sberstarter.categoryFragments.FragmentTabMy;
import com.soloway.banking.sberstarter.detailsFragments.*;


public class MainActivity extends FragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private FragmentTabHost mTabHost;
    private FragmentTabHost mDescrHost;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    
    private Fragment fragmentTabAll = new FragmentTabAll();
    private Fragment fragmentTabMy = new FragmentTabMy();
    private Fragment fragmentTabFav = new FragmentTabFav();
    
    // project page
	private Fragment fragmentProjectAbout = new FragmentProjectAbout();
    private Fragment fragmentProjectAuthor = new FragmentProjectAuthor();
    private Fragment fragmentProjectDiscuss = new FragmentProjectDiscuss();
    private Fragment fragmentProjectFund = new FragmentProjectFund();


    public static MainActivity newInstance() {
        MainActivity mainActivity = new MainActivity ();
        return mainActivity ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Manager.setMainActivity(this);
        createProjectList();

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    public void createProjectPage() {
		mDescrHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mDescrHost.clearAllTabs();
        mDescrHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mDescrHost.addTab(mDescrHost.newTabSpec("about").setIndicator(getResources().getString(R.string.tab_about)),
        		FragmentProjectAbout.class, null);
        mDescrHost.addTab(mDescrHost.newTabSpec("author").setIndicator(getResources().getString(R.string.tab_author)),
        		FragmentProjectAuthor.class, null);
        mDescrHost.addTab(mDescrHost.newTabSpec("discuss").setIndicator(getResources().getString(R.string.tab_discuss)),
        		FragmentProjectDiscuss.class, null);
        mDescrHost.addTab(mDescrHost.newTabSpec("fund").setIndicator(getResources().getString(R.string.tab_fund)),
        		FragmentProjectFund.class, null);
        for(int i=0;i<mDescrHost.getTabWidget().getChildCount();i++) 
        {
            TextView tv = (TextView) mDescrHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#FFFFFF"));
        } 
	 
	}

	private void createProjectList() {
		// project list
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(getResources().getString(R.string.tab_new)),
                FragmentTabAll.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getResources().getString(R.string.tab_my_project)),
                FragmentTabAll.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator(getResources().getString(R.string.tab_my_deposit)),
                FragmentTabAll.class, null);
        for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++) 
        {
            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#FFFFFF"));
        }
	}

    @Override
    public void onNavigationDrawerItemSelected(int position) {
    	
    	switch (position){
	    	case 1:
	    		mDescrHost.clearAllTabs();
	    		createProjectList();
	    		break;
    		case 3:
    	        // project page
    			mTabHost.clearAllTabs();
    	        createProjectPage();
    	        break;

    	}
        // update the main content by replacing fragments
       
        //switch fragments by category
       // Fragment fragment = new CategoryFragment();
/*
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
*/    }

    public void onSectionAttached(int number) {
        switch (number) {
	        case 1:
	            mTitle = getString(R.string.title_section1);
	            break;
	        case 2:
	            mTitle = getString(R.string.title_section2);
	            break;
	        case 3:
	            mTitle = getString(R.string.title_section3);
	            break;
	        case 4:
	            mTitle = getString(R.string.title_section4);
	            break;
	        case 5:
	            mTitle = getString(R.string.title_section5);
	            break;
	        case 6:
	            mTitle = getString(R.string.title_section6);
	            break;
	        case 7:
	            mTitle = getString(R.string.title_section7);
	            break;
	        case 8:
	            mTitle = getString(R.string.title_section8);
	            break;
	        case 9:
	            mTitle = getString(R.string.title_section9);
	            break;
             
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
