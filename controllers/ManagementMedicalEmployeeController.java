package controllers;

import models.Reception;
import views.MainView;
import views.ViewVisitor;

public class ManagementMedicalEmployeeController extends Controller implements ViewVisitor {
    private NurseController nurseController;
    private TechnicianController technicianController;

    public ManagementMedicalEmployeeController(Reception reception) {
        super(reception);
        this.nurseController = new NurseController(this.getReception());
        this.technicianController = new TechnicianController(this.getReception());
    }

    public TechnicianController getTechnicianController() {
        return this.technicianController;
    }

    public NurseController getNurseController() {
        return this.nurseController;
    }

    @Override
    public void interact(MainView viewVisitor) {
        viewVisitor.visit(this);
    }
}
