package controllers;
import models.*;

import java.util.ArrayList;


public class CreateVaccinationController extends Controller {
    private VaccinationNurseInjectController vaccinationNurseInjectController;
    private ManagementPatientController managementPatientController;

    /**
     * Constructor for objects of class CreateVaccinationController
     *
     * @param reception - La clase con la que interactuan los controladores
     *                  con los modelos
     *
     */
    public CreateVaccinationController(Reception reception) {
        super(reception);
        this.vaccinationNurseInjectController = new VaccinationNurseInjectController(this.getReception());
        this.managementPatientController = new ManagementPatientController(this.getReception());
    }

    @Override
    public ClinicError control() {
        return null;
    }

    public void createPfizer(Patient patient, Nurse nurse){
        patient.addToMedicalHistory(new Pfizer(patient,nurse));
    }

    public void createModerna(Patient patient, Nurse nurse){
        patient.addToMedicalHistory(new Pfizer(patient,nurse));
    }

    public void createJohnson(Patient patient, Nurse nurse){
        patient.addToMedicalHistory(new Pfizer(patient,nurse));
    }

    public VaccinationNurseInjectController getVaccinationNurseInjectController(){
        return this.vaccinationNurseInjectController;
    }

    public ManagementPatientController getManagementPatientController(){
        return this.managementPatientController;
    }

    public ArrayList<Vaccine> showVaccinesAvailables(Patient patient) {
        return patient.getVaccineCanInject();
    }
}
