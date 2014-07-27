package com.soloway.banking.sberstarter.detailsFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.soloway.banking.sberstarter.Manager;
import com.soloway.banking.sberstarter.R;
import com.soloway.banking.sberstarter.categoryFragments.FragmentTabAll;

public class FragmentProjectAbout extends Fragment {
    public static final String TAG = FragmentProjectAbout.class.getSimpleName();

    private FragmentTabAll.ProjectData projectData;

    private TextView title;
    private View image;
    private SeekBar progress;
    private TextView collectedMoney;
    private TextView needMoney;
    private TextView members;
    private TextView days;
    private TextView text;
    private TextView location;
    private TextView type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_project_about, container, false);
        title = (TextView) view.findViewById(R.id.title);
        image = (View) view.findViewById(R.id.image);
        progress = (SeekBar) view.findViewById(R.id.progress);
        collectedMoney = (TextView) view.findViewById(R.id.collectedMoney);
        needMoney = (TextView) view.findViewById(R.id.needMoney);
        members = (TextView) view.findViewById(R.id.members);
        days = (TextView) view.findViewById(R.id.days);
        text = (TextView) view.findViewById(R.id.text);
        location = (TextView) view.findViewById(R.id.location);
        type = (TextView) view.findViewById(R.id.type);

        init();

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void init(){
        projectData = Manager.getCurrentProject();
        title.setText(projectData.title);
        image.setBackgroundResource(projectData.imageResources);
        progress.setMax(projectData.needMoney);
        progress.setProgress(projectData.collectedMoney);
        collectedMoney.setText(formatDecimals(projectData.collectedMoney) + " " + getResources().getString(R.string.P));
        needMoney.setText(formatDecimals(projectData.needMoney) + " " + getResources().getString(R.string.P));
        members.setText(String.valueOf(projectData.membersCount));
        days.setText(String.valueOf(projectData.daysCount) + " " + getResources().getString(R.string.dnya));
        text.setText(projectData.text);
        location.setText(projectData.location);
        type.setText(projectData.type);

        progress.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar, int progressCount, boolean fromTouch) {
                        progress.setProgress(projectData.collectedMoney);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        //Nothing
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        progress.setProgress(projectData.collectedMoney);
                    }
                });
    }

    public static StringBuilder formatDecimals(long value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(value / 1000).append(" ").append(value % 1000 == 0 ? "000" : value % 1000);
        return stringBuilder;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
