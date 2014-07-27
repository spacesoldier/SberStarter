package com.soloway.banking.sberstarter.detailsFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.soloway.banking.sberstarter.Manager;
import com.soloway.banking.sberstarter.R;
import com.soloway.banking.sberstarter.categoryFragments.FragmentTabAll;

public class FragmentProjectFund extends Fragment {
    public static final String TAG = FragmentProjectFund.class.getSimpleName();

    private FragmentTabAll.ProjectData projectData;

    private TextView title;
    private View image;
    private SeekBar progress;
    private TextView collectedMoney;
    private TextView needMoney;
    private TextView members;
    private TextView days;
    private TextView location;
    private TextView type;
    private TextView iTunesButton;
    private TextView cdButton;
    private TextView vinilButton;
    private TextView tshirtButton;
    private RelativeLayout choice;
    private ImageView iTunesButtonArrow;
    private ImageView cdButtonArrow;
    private ImageView vinilButtonArrow;
    private ImageView tshirtButtonArrow;
    private boolean isITunesButtonPressed;
    private boolean isVinilButtonPressed;
    private boolean isTshirtButtonPressed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_project_fund, container, false);
        title = (TextView) view.findViewById(R.id.title);
        image = (View) view.findViewById(R.id.image);
        progress = (SeekBar) view.findViewById(R.id.progress);
        collectedMoney = (TextView) view.findViewById(R.id.collectedMoney);
        needMoney = (TextView) view.findViewById(R.id.needMoney);
        members = (TextView) view.findViewById(R.id.members);
        days = (TextView) view.findViewById(R.id.days);
        location = (TextView) view.findViewById(R.id.location);
        type = (TextView) view.findViewById(R.id.type);
        iTunesButton = (TextView) view.findViewById(R.id.iTunesButton);
        cdButton = (TextView) view.findViewById(R.id.cdButton);
        vinilButton = (TextView) view.findViewById(R.id.vinilButton);
        tshirtButton = (TextView) view.findViewById(R.id.tshirtButton);
        choice = (RelativeLayout) view.findViewById(R.id.choice);
        iTunesButtonArrow = (ImageView) view.findViewById(R.id.iTunesButtonArrow);
        cdButtonArrow = (ImageView) view.findViewById(R.id.cdButtonArrow);
        vinilButtonArrow = (ImageView) view.findViewById(R.id.vinilButtonArrow);
        tshirtButtonArrow = (ImageView) view.findViewById(R.id.tshirtButtonArrow);

        iTunesButton.setOnClickListener(buttonClickListener);
        cdButton.setOnClickListener(buttonClickListener);
        vinilButton.setOnClickListener(buttonClickListener);
        tshirtButton.setOnClickListener(buttonClickListener);

        init();

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void init() {
        projectData = Manager.getCurrentProject();
        title.setText(projectData.title);
        image.setBackgroundResource(projectData.imageResources);
        progress.setMax(projectData.needMoney);
        progress.setProgress(projectData.collectedMoney);
        collectedMoney.setText(formatDecimals(projectData.collectedMoney) + " " + getResources().getString(R.string.P));
        needMoney.setText(formatDecimals(projectData.needMoney) + " " + getResources().getString(R.string.P));
        members.setText(String.valueOf(projectData.membersCount));
        days.setText(String.valueOf(projectData.daysCount) + " " + getResources().getString(R.string.dnya));
        location.setText(projectData.location);
        type.setText(projectData.type);
        iTunesButton.setText(appendTextButton(getString(R.string.label_100_P), getString(R.string.itunes_button)));
        cdButton.setText(appendTextButton(getString(R.string.label_200_P), getString(R.string.cd_button)));
        vinilButton.setText(appendTextButton(getString(R.string.label_500_P), getString(R.string.vinil_button)));
        tshirtButton.setText(appendTextButton(getString(R.string.label_1000_P), getString(R.string.tshirt_button)));

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

    public SpannableStringBuilder appendTextButton(String cost, String text) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cost).append("  ").append(text);

        int firstBorder = cost.length();

        final SpannableStringBuilder ssb = new SpannableStringBuilder(stringBuilder);
        final ForegroundColorSpan bss;
        bss = new ForegroundColorSpan(getResources().getColor(R.color.sberstartertheme_color));
        ssb.setSpan(bss, 0, firstBorder, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == cdButton.getId()) {
                if (choice.getVisibility() == View.VISIBLE){
                    choice.setVisibility(View.GONE);
                    cdButtonArrow.setImageResource(R.drawable.vertical_arrow);
                } else {
                    choice.setVisibility(View.VISIBLE);
                    cdButtonArrow.setImageResource(R.drawable.horizontal_arrow);
                }
            } else if (view.getId() == iTunesButton.getId()) {
                if (isITunesButtonPressed){
                    isITunesButtonPressed = false;
                    iTunesButtonArrow.setImageResource(R.drawable.vertical_arrow);
                } else {
                    isITunesButtonPressed = true;
                    iTunesButtonArrow.setImageResource(R.drawable.horizontal_arrow);
                }
            } else if (view.getId() == vinilButton.getId()) {
                if (isVinilButtonPressed){
                    isVinilButtonPressed = false;
                    vinilButtonArrow.setImageResource(R.drawable.vertical_arrow);
                } else {
                    isVinilButtonPressed = true;
                    vinilButtonArrow.setImageResource(R.drawable.horizontal_arrow);
                }
            } else if (view.getId() == tshirtButton.getId()) {
                if (isTshirtButtonPressed){
                    isTshirtButtonPressed = false;
                    tshirtButtonArrow.setImageResource(R.drawable.vertical_arrow);
                } else {
                    isTshirtButtonPressed = true;
                    tshirtButtonArrow.setImageResource(R.drawable.horizontal_arrow);
                }
            }
        }
    };
}
