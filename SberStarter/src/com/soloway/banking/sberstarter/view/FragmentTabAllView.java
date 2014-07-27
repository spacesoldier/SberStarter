package com.soloway.banking.sberstarter.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.soloway.banking.sberstarter.FragmentTabAll;
import com.soloway.banking.sberstarter.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;


/**
 * Created by pens on 27.07.14.
 */
public class FragmentTabAllView extends RelativeLayout {

    private TextView title;
    private View image;
    private SeekBar progress;
    private TextView collectedMoney;
    private TextView needMoney;
    private TextView members;
    private TextView days;

    public FragmentTabAllView(Context c) {
        super(c);
        LayoutInflater inflater = LayoutInflater.from(c);

        if (inflater != null) {
            inflater.inflate(R.layout.tab_all_list_item_layout, this);
            title = (TextView) findViewById(R.id.title);
            image = (View) findViewById(R.id.image);
            progress = (SeekBar) findViewById(R.id.progress);
            collectedMoney = (TextView) findViewById(R.id.collectedMoney);
            needMoney = (TextView) findViewById(R.id.needMoney);
            members = (TextView) findViewById(R.id.members);
            days = (TextView) findViewById(R.id.days);
        }
    }

    public void bindData(final FragmentTabAll.CategoryData categoryData) {
        title.setText(categoryData.title);
        image.setBackgroundResource(categoryData.imageResources);
        progress.setMax(categoryData.needMoney);
        progress.setProgress(categoryData.collectedMoney);
        collectedMoney.setText(formatDecimals(categoryData.collectedMoney) + " " + getResources().getString(R.string.P));
        needMoney.setText(formatDecimals(categoryData.needMoney) + " " + getResources().getString(R.string.P));
        members.setText(String.valueOf(categoryData.membersCount));
        days.setText(String.valueOf(categoryData.daysCount) + " " + getResources().getString(R.string.dnya));

        progress.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar, int progressCount, boolean fromTouch) {
                        progress.setProgress(categoryData.collectedMoney);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        //Nothing
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        progress.setProgress(categoryData.collectedMoney);
                    }
                });
    }

    public static StringBuilder formatDecimals(long value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(value / 1000).append(" ").append(value % 1000 == 0 ? "000" : value % 1000);
        return stringBuilder;
    }
}
