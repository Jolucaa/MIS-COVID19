package clinic.controllers;

import clinic.models.users.Administrator;
import clinic.models.users.PersonalData;

/**
 * Write a description of class AdminController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdminController extends Controller {
    /**
     * crea un usuario administrador
     *
     * @param personalData Objeto que encapsula la informacion general de una persona
     * @return Administrator - Objeto de tipo Admnistrador
     */
    public Administrator create(PersonalData personalData) {
        return new Administrator(personalData);
    }

    public PersonalInformationController getPersonalInformationController() {
        return new PersonalInformationController();
    }
}
