package com.soloway.banking.sberstarter;

import com.soloway.banking.sberstarter.categoryFragments.FragmentTabAll;

/**
 * Created by pens on 27.07.14.
 */
public class Manager {
    private static MainActivity mainActivity;
    private static FragmentTabAll.ProjectData currentProject;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity activity) {
        mainActivity = activity;
    }

    public static FragmentTabAll.ProjectData getCurrentProject() {
        return currentProject;
    }

    public static void setCurrentProject(FragmentTabAll.ProjectData currentProject) {
        Manager.currentProject = currentProject;
    }
}
