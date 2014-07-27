package com.soloway.banking.sberstarter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.soloway.banking.sberstarter.adapter.FragmentTabAllAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentTabAll extends Fragment implements AdapterView.OnItemClickListener {
    public static final String TAG = FragmentTabAll.class.getSimpleName();

    private List<CategoryData> data = new ArrayList<CategoryData>();
    private ListView listView;
    private FragmentTabAllAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_all, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        adapter = new FragmentTabAllAdapter(data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter.isEmpty()) {
            initData();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // TODO redirect to  project details
    }

    private void initData() {
        CategoryData categoryData;
        categoryData = new CategoryData(R.drawable.kasabian, getResources().getString(R.string.category_title_1), 350475, 600000, 630, 44);
        data.add(categoryData);
        categoryData = new CategoryData(R.drawable.nirvana, getResources().getString(R.string.category_title_2), 44475, 50000, 96, 23);
        data.add(categoryData);
    }

    public class CategoryData {
        public int imageResources;
        public String title;
        public int collectedMoney;
        public int needMoney;
        public int membersCount;
        public int daysCount;

        public CategoryData(int imageResources, String title, int collectedMoney, int needMoney, int membersCount, int daysCount) {
            this.imageResources = imageResources;
            this.title = title;
            this.collectedMoney = collectedMoney;
            this.needMoney = needMoney;
            this.membersCount = membersCount;
            this.daysCount = daysCount;
        }
    }
}
