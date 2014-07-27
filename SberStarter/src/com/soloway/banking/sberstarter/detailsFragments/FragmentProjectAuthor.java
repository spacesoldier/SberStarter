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

public class FragmentProjectAuthor extends Fragment {
    public static final String TAG = FragmentProjectAuthor.class.getSimpleName();

    private FragmentTabAll.ProjectData projectData;

    private TextView title;
    private View image;
    private TextView bioButton;
    private TextView projectsButton;
    private TextView contactsButton;
    private RelativeLayout bioChoice;
    private TextView bioChoiceText;
    private RelativeLayout contactsChoice;
    private TextView contactsChoiceText;
    private ImageView bioButtonArrow;
    private ImageView projectsButtonArrow;
    private ImageView contactsButtonArrow;
    private boolean isProjectsButtonPressed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_project_author, container, false);
        title = (TextView) view.findViewById(R.id.title);
        image = (View) view.findViewById(R.id.image);
        bioButton = (TextView) view.findViewById(R.id.bioButton);
        projectsButton = (TextView) view.findViewById(R.id.projectsButton);
        contactsButton = (TextView) view.findViewById(R.id.contactsButton);
        bioChoiceText = (TextView) view.findViewById(R.id.bioChoiceText);
        contactsChoiceText = (TextView) view.findViewById(R.id.contactsChoiceText);
        bioChoice = (RelativeLayout) view.findViewById(R.id.bioChoice);
        contactsChoice = (RelativeLayout) view.findViewById(R.id.contactsChoice);
        bioButtonArrow = (ImageView) view.findViewById(R.id.bioButtonArrow);
        projectsButtonArrow = (ImageView) view.findViewById(R.id.projectsArrow);
        contactsButtonArrow = (ImageView) view.findViewById(R.id.contactsButtonArrow);

        bioButton.setOnClickListener(buttonClickListener);
        contactsButton.setOnClickListener(buttonClickListener);
        projectsButton.setOnClickListener(buttonClickListener);

        init();

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void init() {
        projectData = Manager.getCurrentProject();
        title.setText(projectData.author);
        image.setBackgroundResource(projectData.imageAuthorResources);
        bioChoiceText.setText(projectData.bio);
        contactsChoiceText.setText(projectData.contacts);
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bioButton.getId()) {
                if (bioChoice.getVisibility() == View.VISIBLE){
                    bioChoice.setVisibility(View.GONE);
                    bioButtonArrow.setImageResource(R.drawable.vertical_arrow);
                } else {
                    bioChoice.setVisibility(View.VISIBLE);
                    bioButtonArrow.setImageResource(R.drawable.horizontal_arrow);
                }
            } else if (view.getId() == projectsButton.getId()) {
                if (isProjectsButtonPressed){
                    isProjectsButtonPressed = false;
                    projectsButtonArrow.setImageResource(R.drawable.vertical_arrow);
                } else {
                    isProjectsButtonPressed = true;
                    projectsButtonArrow.setImageResource(R.drawable.horizontal_arrow);
                }
            } else if (view.getId() == contactsButton.getId()) {
                if (contactsChoice.getVisibility() == View.VISIBLE){
                    contactsChoice.setVisibility(View.GONE);
                    contactsButtonArrow.setImageResource(R.drawable.vertical_arrow);
                } else {
                    contactsChoice.setVisibility(View.VISIBLE);
                    contactsButtonArrow.setImageResource(R.drawable.horizontal_arrow);
                }
            }
        }
    };
}
