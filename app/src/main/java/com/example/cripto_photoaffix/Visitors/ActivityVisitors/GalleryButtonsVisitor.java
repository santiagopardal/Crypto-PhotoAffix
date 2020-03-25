package com.example.cripto_photoaffix.Visitors.ActivityVisitors;

import com.example.cripto_photoaffix.Activities.GalleryActivities.GalleryActivity;
import com.example.cripto_photoaffix.Activities.GalleryActivities.ImageViewerActivity;
import com.example.cripto_photoaffix.Activities.LoginActivity;

public class GalleryButtonsVisitor implements ActivityVisitor {
    @Override
    public void visit(GalleryActivity activity) {
        activity.refresh();

        activity.hideButtons();

        activity.changeState(activity.getState().getNextState());
    }

    @Override
    public void visit(LoginActivity activity) {}

    @Override
    public void visit(ImageViewerActivity activity) {}
}