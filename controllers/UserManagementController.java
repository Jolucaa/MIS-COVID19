package controllers;

import models.*;
import views.ControllerViewVisitor;
import views.ViewVisitor;

public class UserManagementController extends Controller implements ViewVisitor {
    private CreateNurseController createNurseController;
    private SwitchUserController switchUserController;
    private AdminCreatorController adminCreatorController;
    private CreateTechnicianController createTechnicianController;
    private ManagementPatientController managementPatientController;


    public UserManagementController(Reception reception) {
        super(reception);
        this.switchUserController = new SwitchUserController(this.getReception());
        this.createNurseController = new CreateNurseController(this.getReception());
        this.adminCreatorController = new AdminCreatorController(this.getReception());
        this.createTechnicianController = new CreateTechnicianController(this.getReception());
        this.managementPatientController = new ManagementPatientController(this.getReception());
    }


    public ClinicError control() {
        return null;
    }

    public Administrator createAdmin(PersonalInformation personalInformation) {
        return this.getAdminCreatorController().create(personalInformation);
    }

    public CreateTechnicianController getCreateTechnicianController() {
        return this.createTechnicianController;
    }

    public void createNurseController(PersonalInformation personalInformation) {
        this.getCreateNurseController().create(personalInformation);
    }

    public CreateNurseController getCreateNurseController(){
        return this.createNurseController;
    }

    public SwitchUserController getSwitchUserController() {
        return switchUserController;
    }

    public AdminCreatorController getAdminCreatorController() {
        return adminCreatorController;
    }

    public ManagementPatientController getManagementPatientController() {
        return managementPatientController;
    }


    public void exit() {
        this.getReception().setState(States.EXIT);
    }

    @Override
    public void interact(ControllerViewVisitor viewVisitor) {
        viewVisitor.visit(this);
    }
}
