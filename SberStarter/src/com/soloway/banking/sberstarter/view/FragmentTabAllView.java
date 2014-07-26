package com.soloway.banking.sberstarter.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.soloway.banking.sberstarter.FragmentTabAll;
import com.soloway.banking.sberstarter.R;


/**
 * Created by pens on 27.07.14.
 */
public class FragmentTabAllView extends RelativeLayout {

    private TextView title;
    private View image;

    public FragmentTabAllView(Context c) {
        super(c);
        LayoutInflater inflater = LayoutInflater.from(c);

        if (inflater != null) {
            inflater.inflate(R.layout.tab_all_list_item_layout, this);
            title = (TextView) findViewById(R.id.title);
            image = (View) findViewById(R.id.image);
        }
    }

    public void bindData(FragmentTabAll.CategoryData categoryData) {
        title.setText(categoryData.title);
        image.setBackgroundResource(categoryData.imageResources);
    }
}
