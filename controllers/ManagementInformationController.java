package controllers;

import models.Reception;
import views.MainView;
import views.ManagementView;
import views.ViewVisitor;

public class ManagementInformationController extends Controller implements ManagementController, ViewVisitor {

    private Reception reception;

    public ManagementInformationController(Reception reception) {
        super(reception);
    }


    @Override
    public void accept(ManagementView managementView) {
        managementView.visit(this);
    }

    @Override
    public void interact(MainView viewVisitor) {

    }
}
