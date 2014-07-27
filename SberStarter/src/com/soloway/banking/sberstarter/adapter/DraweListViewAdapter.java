package com.soloway.banking.sberstarter.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.soloway.banking.sberstarter.view.DrawerListItemView;

/**
 * Created by pens on 27.07.14.
 */
public class DraweListViewAdapter extends BaseAdapter {

    private String[] titles;
    private int current;

    public DraweListViewAdapter(String[] titles, int current) {
        this.titles = titles;
        this.current = current;
    }

    public void setCurrent(int current){
        this.current = current;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public String getItem(int i) {
        return titles[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        String title = getItem(position);
        DrawerListItemView view = (convertView == null) ? new DrawerListItemView(viewGroup.getContext()) : (DrawerListItemView) convertView;
        view.bindData(title,current == position);
        return view;
    }
}
