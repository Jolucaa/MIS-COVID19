package controllers;

import models.MedicalProcedure;
import models.Reception;
import models.errors.ClinicError;
import models.errors.ErrorPatientWithoutProcedures;
import views.MainView;
import views.ManagementView;
import views.ViewVisitor;

import java.util.List;

/**
 * Write a description of class ManagementProcedureController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ManagementProcedureController extends Controller implements ManagementController, ViewVisitor {
    private CreateVaccinationController createVaccinationController;

    /**
     * Constructor for objects of class ManagementProcedureController
     */
    public ManagementProcedureController(Reception reception) {
        super(reception);
        this.createVaccinationController = new CreateVaccinationController(this.getReception());
    }

    public void accept(ManagementView view) {
        view.visit(this);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *
     */
    public ClinicError control() {
        ClinicError error = new ClinicError();
        List<MedicalProcedure> proceduresOfPatient =
                this.getReception().getMedicalProcessForPatient(this.getReception().getPatientList().get(0));
        if(proceduresOfPatient.isEmpty()){
            error.add(new ErrorPatientWithoutProcedures());
        }
        return error;
    }

    @Override
    public void interact(MainView viewVisitor) {
        viewVisitor.visit(this);
    }

    public CreateVaccinationController getCreateVaccinationController() {
        return createVaccinationController;
    }
}
