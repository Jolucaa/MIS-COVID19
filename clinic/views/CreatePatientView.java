package clinic.views;

import clinic.controllers.PatientController;
import clinic.controllers.PersonalInformationController;
import clinic.models.users.PersonalData;
import utils.Console;

public class CreatePatientView extends ClinicView{

    public void interact() {
        this.write();
        PersonalData personalData = new PersonalInformationView().interact(new PersonalInformationController());
        Integer SIP = Console.getConsole().readInteger("Introduce la SIP del paciente");
        new PatientController().create(personalData, SIP);

    }

    @Override
    public void write() {
        this.writeConsole("--Creacion de Usuario--");
    }
}
