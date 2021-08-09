package controllers;

import models.MedicalProcedure;
import models.Patient;
import models.PersonalInformation;
import models.Reception;

import java.util.List;

/**
 * Write a description of class NewPatientController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PatientController extends Controller {

    private PersonalInformationController personalInformationController;

    /**
     * Constructor for objects of class NewPatientController
     */
    public PatientController(Reception reception) {
        super(reception);
        this.personalInformationController = new PersonalInformationController();
    }

    public void create(PersonalInformation personalInformation, Integer SIP) {
        this.getReception().registerPatient(personalInformation, SIP);
    }

    public List<Patient> showPatientsAvailable() {
        return this.getReception().getPatientList();
    }

    public PersonalInformationController getPersonalInformationController() {
        return this.personalInformationController;
    }

    public List<MedicalProcedure> getMedicalProcessForPatient(Patient patient) {
        return patient.getMedicalProcessForPatient();
    }
}
