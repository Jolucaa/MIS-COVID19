package views;

import controllers.VaccinationController;
import models.Patient;
import models.Vaccine;
import utils.Console;

import java.util.List;

public class CreateVaccinationView extends ClinicView {

    public void interact(VaccinationController vaccinationController) {
        this.write();
        List<Patient> patientList = vaccinationController.showPatientsAvailable();
        this.writeList(patientList, vaccinationController);
        List<Vaccine> listOfVaccines = vaccinationController.showVaccinesAvailable(this.getPatient());
        new VaccineInjectNurseView().interact(vaccinationController, this.getPatient());
        this.getConsole().readInteger("Eliga una opcion: ");
        Console.getConsole().writeln();
    }

    @Override
    protected void write() {
        this.writeConsole("--Menu de administracion de vacunas--");
    }

}

