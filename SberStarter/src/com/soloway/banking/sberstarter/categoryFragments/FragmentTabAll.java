package com.soloway.banking.sberstarter.categoryFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.soloway.banking.sberstarter.Manager;
import com.soloway.banking.sberstarter.R;
import com.soloway.banking.sberstarter.adapter.FragmentTabAllAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentTabAll extends Fragment {
    public static final String TAG = FragmentTabAll.class.getSimpleName();

    private List<ProjectData> data = new ArrayList<ProjectData>();
    private ListView listView;
    private FragmentTabAllAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_all, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        adapter = new FragmentTabAllAdapter(data, onClickListener);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter.isEmpty()) {
            initData();
        }
    }

    private void initData() {
        ProjectData projectData;
        projectData = new ProjectData(R.drawable.kasabian, R.drawable.kasabian_author,getResources().getString(R.string.author_1),getResources().getString(R.string.category_title_1), getResources().getString(R.string.bio_1), getResources().getString(R.string.contacts_1),350475, 600000, 630, 44, getString(R.string.text_1), getString(R.string.location_1), getString(R.string.type));
        data.add(projectData);
        projectData = new ProjectData(R.drawable.nirvana, R.drawable.nirvana_author, getResources().getString(R.string.author_2),getResources().getString(R.string.category_title_2), getResources().getString(R.string.bio_2), getResources().getString(R.string.contacts_2), 44475, 50000, 96, 23, getString(R.string.text_1), getString(R.string.location_2), getString(R.string.type));
        data.add(projectData);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Manager.setCurrentProject(data.get((Integer) view.getTag()));
            Manager.getMainActivity().createProjectPage();
        }
    };

    public class ProjectData {
        public int imageResources;
        public int imageAuthorResources;
        public String author;
        public String title;
        public String bio;
        public String contacts;
        public int collectedMoney;
        public int needMoney;
        public int membersCount;
        public int daysCount;
        public String text;
        public String location;
        public String type;

        public ProjectData(int imageResources, int imageAuthorResources, String author, String title, String bio, String contacts, int collectedMoney, int needMoney, int membersCount, int daysCount, String text, String location, String type) {
            this.imageResources = imageResources;
            this.imageAuthorResources = imageAuthorResources;
            this.author = author;
            this.title = title;
            this.bio = bio;
            this.contacts = contacts;
            this.collectedMoney = collectedMoney;
            this.needMoney = needMoney;
            this.membersCount = membersCount;
            this.daysCount = daysCount;
            this.text = text;
            this.location = location;
            this.type = type;
        }
    }
}
