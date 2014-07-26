package com.soloway.banking.sberstarter.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.soloway.banking.sberstarter.FragmentTabAll;
import com.soloway.banking.sberstarter.view.FragmentTabAllView;

import java.util.List;

/**
 * Created by pens on 27.07.14.
 */
public class FragmentTabAllAdapter extends BaseAdapter {

    private List<FragmentTabAll.CategoryData> data;

    public FragmentTabAllAdapter(List<FragmentTabAll.CategoryData> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public FragmentTabAll.CategoryData getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        FragmentTabAll.CategoryData categoryData = getItem(position);
        FragmentTabAllView view = (convertView == null) ? new FragmentTabAllView(viewGroup.getContext()) : (FragmentTabAllView) convertView;
//        view.setPosition(position);
        view.bindData(categoryData);
        return view;
    }
}
