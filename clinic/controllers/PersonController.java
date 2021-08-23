package clinic.controllers;

public abstract class PersonController extends Controller {
    private PersonalInformationController personalInformationController;

    /**
     * Constructor for objects of class NewPatientController
     */
    public PersonController() {
        this.personalInformationController = new PersonalInformationController();
    }

    public PersonalInformationController getPersonalInformationController() {
        return this.personalInformationController;
    }
}
