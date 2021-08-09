package controllers;

import models.Administrator;
import models.PersonalInformation;
import models.Reception;
import views.MainView;
import views.ViewVisitor;

public class ManagementUserController extends Controller implements ViewVisitor {
    private SwitchUserController switchUserController;
    private AdminController adminController;
    private PatientController patientController;
    private ManagementMedicalEmployeeController managementMedicalEmployeeController;


    public ManagementUserController(Reception reception) {
        super(reception);
        this.switchUserController = new SwitchUserController(this.getReception());
        this.adminController = new AdminController(this.getReception());
        this.patientController = new PatientController(this.getReception());
        this.managementMedicalEmployeeController = new ManagementMedicalEmployeeController(this.getReception());
    }

    public Administrator createAdmin(PersonalInformation personalInformation) {
        return this.getAdminController().create(personalInformation);
    }

    public SwitchUserController getSwitchUserController() {
        return switchUserController;
    }

    public AdminController getAdminController() {
        return adminController;
    }

    public PatientController getPatientController() {
        return patientController;
    }

    public ManagementMedicalEmployeeController getManagementMedicalEmployeeController() {
        return this.managementMedicalEmployeeController;
    }

    @Override
    public void interact(MainView viewVisitor) {
        viewVisitor.visit(this);
    }
}
