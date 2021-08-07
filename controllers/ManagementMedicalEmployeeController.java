package controllers;

import models.Reception;
import views.MainView;
import views.ManagementView;

public class ManagementMedicalEmployeeController extends Controller implements ManagementController {
    public ManagementMedicalEmployeeController(Reception reception) {
        super(reception);
    }


    @Override
    public void accept(ManagementView view) {
        view.visit(this);
    }

    @Override
    public void interact(MainView viewVisitor) {
        viewVisitor.visit(this);
    }
}
