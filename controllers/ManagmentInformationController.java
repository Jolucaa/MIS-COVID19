package controllers;

import models.ClinicError;
import models.Reception;
import views.ControllerViewVisitor;
import views.OperationalView;
import views.ViewVisitor;

public class ManagmentInformationController extends Controller implements ManagmentController, ViewVisitor {
    private Reception reception;

    public ManagmentInformationController(Reception reception) {
        super(reception);
    }

    @Override
    public ClinicError control() {
        return null;
    }

    @Override
    public void accept(OperationalView view) {

    }

    @Override
    public void interact() {

    }

    @Override
    public void interact(ControllerViewVisitor viewVisitor) {
        viewVisitor.visit(this);;
    }
}
