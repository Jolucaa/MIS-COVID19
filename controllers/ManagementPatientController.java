package controllers;

import models.Patient;
import models.PersonalInformation;
import models.Reception;

import java.util.List;

public class ManagementPatientController extends Controller {
    private PatientController patientController;

    public ManagementPatientController(Reception reception) {
        super(reception);
        this.patientController = new PatientController(reception);
    }

    public List<Patient> showPatientsAvailable() {
        return this.getReception().getPatientList();
    }

    public void createPatient(PersonalInformation personalInformation, Integer SIP) {
        this.getCreatePatientController().create(personalInformation, SIP);
    }

    public PatientController getCreatePatientController() {
        return patientController;
    }
}
