package controllers;

import models.*;
import models.errors.ClinicError;

import java.util.List;


public class VaccinationController extends Controller implements MedicalVaccineVisitor {
    private PatientController patientController;

    /**
     * Constructor for objects of class VaccinationController
     *
     * @param reception - La clase con la que interactuan los controladores
     *                  con los modelos
     */
    public VaccinationController(Reception reception) {
        super(reception);
        this.patientController = new PatientController(this.getReception());
    }

    public void createPfizer(Patient patient, Nurse nurse) {
        patient.addToMedicalHistory(new Pfizer(patient, nurse));
    }

    public void createModerna(Patient patient, Nurse nurse) {
        patient.addToMedicalHistory(new Pfizer(patient, nurse));
    }

    public void createJohnson(Patient patient, Nurse nurse) {
        patient.addToMedicalHistory(new Pfizer(patient, nurse));
    }

    private PatientController getPatientController() {
        return this.patientController;
    }

    public List<Patient> showPatientsAvailable() {
        return this.getPatientController().showPatientsAvailable();
    }

    public List<Vaccine> showVaccinesAvailable(Patient patient) {
        return patient.getVaccineCanInject();
    }

    public List<Vaccine> getVaccineCanInject(Patient patient) {
        return this.getReception().getVaccineCanInject(patient);
    }

    @Override
    public ClinicError visit(Pfizer pfizer) {

        return null;
    }

    @Override
    public ClinicError visit(Moderna moderna) {

        return null;
    }

    @Override
    public ClinicError visit(Johnson johnson) {

        return null;
    }

    public void accept(Vaccine procedure) {
        procedure.accept(this);
    }
}
