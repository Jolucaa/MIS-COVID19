package models;

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
    protected PersonalInformation getPersonalInformation(Patient patient) {
        return patient.getPersonalInformation();
    }

    @Override
    protected List<Patient> getList() {
        return this.patients;
    }

    @Override
    protected Integer getId(Patient patient) {
        return patient.getSIP();
    }

    @Override
    public Patient create(PersonalInformation personalInformation) {
        return new Patient(personalInformation);
    }

    public Patient create(PersonalInformation personalInformation, Integer SIP) {
        return new Patient(personalInformation, SIP);
    }
    
    public boolean isPriorityPatient(){
        for (Patient patient : this.getList()) {
            if (this.isPriority(patient)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isPriority(Patient patient){
        return patient.getAge() >= PatientManager.AGE_FOR_PRIORITY_PATIENT;
    }

    
}
