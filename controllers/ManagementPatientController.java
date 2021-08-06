package controllers;

import models.*;
import views.MainView;

import java.util.List;

public class ManagementPatientController extends Controller {
    private CreatePatientController createPatientController;

    public ManagementPatientController(Reception reception) {
        super(reception);
        this.createPatientController = new CreatePatientController(reception);
    }

    public List<Patient> showPatientsAvailable(){
        return this.getReception().getPatientList();
    }

    public void createPatient(PersonalInformation personalInformation, Integer age, Integer SIP){
        this.getCreatePatientController().create(personalInformation, SIP);
    }

    public CreatePatientController getCreatePatientController() {
        return createPatientController;
    }

    @Override
    public void interact(MainView viewVisitor) {
        this.showPatientsAvailable();
    }
}
