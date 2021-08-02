package views;

import controllers.CreateVaccinationController;
import models.Patient;
import utils.Console;

import java.util.ArrayList;

public class CreateVaccinationView extends ClinicView {
    private Patient patient;

    public void interact(CreateVaccinationController vaccinationController) {
        this.writeConsole("--Menu de administracuion de vacunas--");
        this.write(vaccinationController);
        vaccinationController.showVaccinesAvailables(this.getPatient());
        new VaccineInjectNurseView().interact(vaccinationController.getVaccinationNurseInjectController(), this.getPatient());
        this.getConsole().readInteger("Eliga una opcion: ");
        Console.getConsole().writeln();

    }


    protected void write(CreateVaccinationController vaccinationController) {
        ArrayList<Patient> patientArrayList = vaccinationController.getManagementPatientController().showPatientsAvailable();
        if (!patientArrayList.isEmpty()) {
            for (Patient patient : patientArrayList) {
                this.writeConsole(patientArrayList.listIterator().previousIndex() + " " + patient.getNameFormat() + " " + patient.getSIP());
            }
            Integer personSelected = Console.getConsole().readInteger("Seleccione un paciente de la lista por su numero: ");
            Patient patient = patientArrayList.get(personSelected);
            this.setPatient(patient);
        }else{
            this.writeConsole("No se han encontrado pacientes");
            this.restart(vaccinationController);
        }
    }

    protected Patient getPatient() {
        return this.patient;
    }

    @Override
    protected void write() {

    }

    protected void setPatient(Patient patient) {
        this.patient = patient;
    }
}

