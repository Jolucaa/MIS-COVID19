package clinic.controllers;

import clinic.models.users.Patient;
import clinic.models.users.PersonalData;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class PatientManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PatientManager extends GenericManager<Patient> {
    // instance variables - replace the example below with your own
    private final ArrayList<Patient> patients;
    private static final Integer AGE_FOR_PRIORITY_PATIENT = 65;
    /**
     * Constructor for objects of class PatientManager
     */
    public PatientManager() {
        this.patients = new ArrayList<>();
    }


    @Override
    protected PersonalData getPersonalInformation(Patient patient) {
        return patient.getPersonalInformation();
    }

    @Override
    public List<Patient> getList() {
        return this.patients;
    }

    @Override
    protected Integer getId(Patient patient) {
        return patient.getSIP();
    }

    @Override
    public Patient create(PersonalData personalData) {
        return new Patient(personalData);
    }

    @Override
    public void edit(Patient person) {
        //TODO EDICION de persona
    }

    public Patient create(PersonalData personalData, Integer SIP) {
        return new Patient(personalData, SIP);
    }

    public boolean isPriorityPatient() {
        for (Patient patient : this.getList()) {
            if (this.isPriority(patient)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPriority(Patient patient) {
        return patient.getAge() >= PatientManager.AGE_FOR_PRIORITY_PATIENT;
    }

    
}
