package clinic.controllers;

import clinic.models.users.Administrator;
import clinic.models.users.PersonalData;

public class ManagementUserController extends Controller {
    private SwitchUserController switchUserController;
    private AdminController adminController;
    private PatientController patientController;
    private ManagementMedicalEmployeeController managementMedicalEmployeeController;


    public ManagementUserController() {
        this.switchUserController = new SwitchUserController();
        this.adminController = new AdminController();
        this.patientController = new PatientController();
        this.managementMedicalEmployeeController = new ManagementMedicalEmployeeController();
    }

    public Administrator createAdmin(PersonalData personalData) {
        return this.getAdminController().create(personalData);
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
}
