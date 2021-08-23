package clinic.views;

import clinic.controllers.PatientController;
import clinic.controllers.VaccinationController;
import clinic.models.users.Patient;
import utils.Console;

import java.util.List;

public class CreateVaccinationView extends ClinicView {

    public void interact() {
        VaccinationController vaccinationController = new VaccinationController();
        PatientController patientController = new PatientController();
        this.write();
        List<String> patientList = patientController.showPatientsAvailable();
        this.writeList(patientList);
        Patient patient = patientController.getPatient(this.getConsole().readInteger("Eliga una opcion: "));
        Console.getConsole().writeln();
        //List<String> listOfVaccines = vaccinationController.getVaccineCanInject(patient);
        //this.writeList(listOfVaccines);
        //TODO hacer writeList polimorfico para cualquier lista de usuarios
        this.getConsole().readInteger("Eliga una opcion: ");
        Console.getConsole().writeln();
    }

    @Override
    public void write() {
        this.writeConsole("--MainMenu de administracion de vacunas--");
    }

}

