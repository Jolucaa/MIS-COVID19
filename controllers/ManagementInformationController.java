package controllers;

import models.Reception;
import views.MainView;
import views.ViewVisitor;

public class ManagementInformationController extends Controller implements ViewVisitor {

    public ManagementInformationController(Reception reception) {
        super(reception);
    }

    @Override
    public void interact(MainView viewVisitor) {

    }
}
