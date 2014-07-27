package com.soloway.banking.sberstarter.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.soloway.banking.sberstarter.R;

/**
 * Created by pens on 27.07.14.
 */
public class DrawerListItemView extends RelativeLayout {

    private TextView title;

    public DrawerListItemView(Context c) {
        super(c);
        LayoutInflater inflater = LayoutInflater.from(c);

        if (inflater != null) {
            inflater.inflate(R.layout.drawer_list_item_layout, this);
            title = (TextView) findViewById(R.id.title);
        }
    }

    public void bindData(String name, boolean isCurrent) {
        title.setText(name);
        if(isCurrent){
            setBackgroundColor(getResources().getColor(R.color.sberstartertheme_color));
        } else {
            setBackgroundColor(getResources().getColor(R.color.list_background_drawer));
        }
    }
}
