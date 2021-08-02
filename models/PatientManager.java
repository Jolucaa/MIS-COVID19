package models;

import java.util.ArrayList;
import java.util.Random;

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
    protected ArrayList<Patient> getArrayList() {
        return this.patients;
    }

    @Override
    protected Integer getId(Patient patient) {
        return patient.getSIP();
    }

    @Override
    public Patient create(PersonalInformation personalInformation) {
        Random randomGenerator = new Random();
        return this.create(personalInformation, randomGenerator.nextInt(2), randomGenerator.nextInt(7));
    }

    public Patient create(PersonalInformation personalInformation, Integer age, Integer SIP) {
        return new Patient(personalInformation, age, SIP);
    }
    
    public boolean isPriorityPatient(){
        for (Patient patient: this.getArrayList()) {
            if(this.isPriority(patient)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isPriority(Patient patient){
        return patient.getAge() >= PatientManager.AGE_FOR_PRIORITY_PATIENT;
    }

    
}
