package views;

import controllers.PatientController;
import models.PersonalInformation;
import utils.Console;

public class CreatePatientView extends ClinicView{

    public void interact(PatientController patientController) {
        this.write();
        PersonalInformation personalInformation = new PersonalInformationView().interact(patientController.getPersonalInformationController());
        Integer SIP = Console.getConsole().readInteger("Introduce la SIP del paciente");
        patientController.create(personalInformation, SIP);

    }

    @Override
    protected void write() {
        this.writeConsole("--Creacion de Usuario--");
    }
}
