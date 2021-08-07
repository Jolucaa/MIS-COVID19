package views;

import controllers.CreatePatientController;
import models.PersonalInformation;
import utils.Console;

public class CreatePatientView extends ClinicView{

    public void interact(CreatePatientController createPatientController){
        this.write();
        PersonalInformation personalInformation = new PersonalInformationView().interact(createPatientController.getPersonalInformationController());
        Integer SIP = Console.getConsole().readInteger("Introduce la SIP del paciente");
        createPatientController.create(personalInformation, SIP);

    }

    @Override
    protected void write() {
        this.writeConsole("--Creacion de Usuario--");
    }
}
