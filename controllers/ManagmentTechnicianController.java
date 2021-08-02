package controllers;

import models.ClinicError;
import models.ErrorAcces;
import models.Reception;
import views.OperationalView;

public class ManagmentTechnicianController extends Controller implements ManagmentController{
    public ManagmentTechnicianController(Reception reception) {
        super(reception);
    }

    @Override
    public ClinicError control() {
        return new ErrorAcces();
    }

    @Override
    public void accept(OperationalView view) {

    }

    @Override
    public void interact() {

    }
}
