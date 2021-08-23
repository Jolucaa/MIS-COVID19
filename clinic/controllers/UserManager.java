package clinic.controllers;

import clinic.models.TechnicianManager;
import clinic.models.users.Nurse;
import clinic.models.users.Patient;
import clinic.models.users.PersonalData;
import clinic.models.users.Technician;

/**
 * Write a description of class UserManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class UserManager {
    // instance variables - replace the example below with your own
    private final NurseManager nurseManager;
    private final TechnicianManager technicianManager;
    private final PatientManager patientManager;

    /**
     * Constructor for objects of class UserManager
     */
    protected UserManager() {
        this.nurseManager = new NurseManager();
        this.technicianManager = new TechnicianManager();
        this.patientManager = new PatientManager();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param nurse un objeto de la clase Nurse
     */
    public void register(Nurse nurse) {
        this.getNurseManager().register(nurse);
    }

    protected NurseManager getNurseManager() {
        return nurseManager;
    }

    public void register(Technician technician) {
        this.getTechnicianManager().register(technician);
    }

    protected TechnicianManager getTechnicianManager() {
        return technicianManager;
    }

    public Technician createTechnician(PersonalData personalData) {
        return this.getTechnicianManager().create(personalData);
    }

    public Nurse createNurse(PersonalData personalData) {
        return this.getNurseManager().create(personalData);
    }

    public void register(Patient patient) {
        this.getPatientManager().register(patient);
    }

    private PatientManager getPatientManager() {
        return patientManager;
    }

    public Patient createPatient(PersonalData personalData, Integer SIP) {
        return this.getPatientManager().create(personalData, SIP);
    }

    public void add(Technician technician) {
        this.getTechnicianManager().add(technician);
    }

    public void add(Nurse nurse) {
        this.getNurseManager().add(nurse);
    }

    public void add(Patient patient) {
        this.getPatientManager().add(patient);
    }


}
