package views.strategy;

import controllers.PatientController;
import controllers.PersonalInformationController;
import models.PersonalInformation;
import utils.Console;

public class CreatePatientAlgorithm extends Create {
    private PatientController patientController;

    public CreatePatientAlgorithm(PatientController patientController) {
        this.patientController = patientController;
    }

    @Override
    public void execute() {
        PersonalInformation personalInformation = this.obtainPersonalInformation(new PersonalInformationController());
        Integer SIP = Console.getConsole().readInteger("Introduce la SIP del paciente");
        patientController.create(personalInformation, SIP);

    }

    @Override
    public String getTitle() {
        return "Crear Usuario";
    }
}
