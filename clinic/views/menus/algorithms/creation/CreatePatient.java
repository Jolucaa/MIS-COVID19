package clinic.views.menus.algorithms.creation;

import clinic.controllers.PatientController;
import clinic.controllers.PersonalInformationController;
import clinic.models.users.PersonalData;
import clinic.views.PersonalInformationView;
import utils.Console;

public class CreatePatient extends CreatePerson {

    public CreatePatient(PatientController patientController) {
        super(patientController);
    }

    @Override
    public void createSpecificTypePerson() {
        Integer SIP = Console.getConsole().readInteger("Introduce la SIP del paciente");
        PersonalData personalData = new PersonalInformationView().interact(new PersonalInformationController());
        this.getPatientController().create(personalData, SIP);

    }

    @Override
    public String getTitle() {
        return "Crear Usuario";
    }
}
