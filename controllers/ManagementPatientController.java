package controllers;

import models.*;

import java.util.ArrayList;

public class ManagementPatientController extends Controller {
    private CreatePatientController createPatientController;

    public ManagementPatientController(Reception reception) {
        super(reception);
        this.createPatientController = new CreatePatientController(reception);
    }

    @Override
    public ClinicError control() {
        this.showPatientsAvailable();
        return null;
    }

    public ArrayList<Patient> showPatientsAvailable(){
        return this.getReception().getPatientList();
    }

    public void createPatient(PersonalInformation personalInformation, Integer age, Integer SIP){
        this.getCreatePatientController().create(personalInformation,age,SIP);
    }

    public CreatePatientController getCreatePatientController() {
        return createPatientController;
    }
}
