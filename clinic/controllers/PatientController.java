package clinic.controllers;

import clinic.models.medical.MedicalProcedure;
import clinic.models.users.Patient;
import clinic.models.users.PersonalData;

import java.util.List;

/**
 * Write a description of class NewPatientController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PatientController extends Controller {
    private PatientManager patientManager;

    /**
     * Constructor for objects of class NewPatientController
     */
    public PatientController() {
        this.patientManager = new PatientManager();
    }

    public void register(Patient patient) {
        this.getPatientManager().register(patient);
    }

    public void create(PersonalData personalData, Integer SIP) {
        this.getPatientManager().create(personalData, SIP);
    }

    private PatientManager getPatientManager() {
        return patientManager;
    }


    public List<String> showPatientsAvailable() {
        // TODO pasar a string
        //return this.getAdministrator().getPatientList();
        return null;
    }

    public List<MedicalProcedure> getMedicalProcessForPatient(Patient patient) {
        return patient.getMedicalStatistics().getPatientAvailableProcess();
    }

    public Patient getPatient(int index) {
        return this.getPatientManager().getList().get(index);
    }

}
