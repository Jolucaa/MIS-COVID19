package controllers;

import models.Administrator;
import models.PersonalInformation;
import models.Reception;
import models.States;
import views.MainView;
import views.ViewVisitor;

public class ManagementUserController extends Controller implements ViewVisitor {
    private NurseController nurseController;
    private SwitchUserController switchUserController;
    private AdminCreatorController adminCreatorController;
    private TechnicianController technicianController;
    private ManagementPatientController managementPatientController;


    public ManagementUserController(Reception reception) {
        super(reception);
        this.switchUserController = new SwitchUserController(this.getReception());
        this.nurseController = new NurseController(this.getReception());
        this.adminCreatorController = new AdminCreatorController(this.getReception());
        this.technicianController = new TechnicianController(this.getReception());
        this.managementPatientController = new ManagementPatientController(this.getReception());
    }

    public Administrator createAdmin(PersonalInformation personalInformation) {
        return this.getAdminCreatorController().create(personalInformation);
    }

    public TechnicianController getCreateTechnicianController() {
        return this.technicianController;
    }

    public void createNurse(PersonalInformation personalInformation) {
        this.getCreateNurseController().create(personalInformation);
    }

    public NurseController getCreateNurseController() {
        return this.nurseController;
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
    public void interact(MainView viewVisitor) {
        viewVisitor.visit(this);
    }
}
