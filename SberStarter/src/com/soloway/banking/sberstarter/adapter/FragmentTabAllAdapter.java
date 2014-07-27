package com.soloway.banking.sberstarter.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.soloway.banking.sberstarter.categoryFragments.FragmentTabAll;
import com.soloway.banking.sberstarter.view.FragmentTabAllView;

import java.util.List;

/**
 * Created by pens on 27.07.14.
 */
public class FragmentTabAllAdapter extends BaseAdapter {

    private List<FragmentTabAll.ProjectData> data;
    private View.OnClickListener onClickListener;

    public FragmentTabAllAdapter(List<FragmentTabAll.ProjectData> data, View.OnClickListener onClickListener) {
        this.data = data;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public FragmentTabAll.ProjectData getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        FragmentTabAll.ProjectData projectData = getItem(position);
        FragmentTabAllView view = (convertView == null) ? new FragmentTabAllView(viewGroup.getContext()) : (FragmentTabAllView) convertView;
        view.setPosition(position);
        view.bindData(projectData,onClickListener);
        return view;
    }
}
