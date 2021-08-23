package clinic.views.menus.algorithms.creation;

import clinic.controllers.PatientController;
import clinic.controllers.PersonalInformationController;
import clinic.models.users.PersonalData;

public abstract class CreatePerson extends CreateAlgorithm {
    private PatientController patientController;

    protected CreatePerson(PatientController patientController) {
        this.patientController = patientController;
    }

    public void execute() {
        PersonalData personalData = this.askPersonalInformation(new PersonalInformationController());
        this.createSpecificTypePerson();
    }

    protected abstract void createSpecificTypePerson();

    protected PatientController getPatientController() {
        return this.patientController;
    }
}
