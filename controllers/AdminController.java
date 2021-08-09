package controllers;

import models.Administrator;
import models.PersonalInformation;
import models.Reception;

/**
 * Write a description of class AdminController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdminController extends Controller {
    /**
     * m
     * Construcor generico para instanciar la clase y guardar el objeto
     * Reception en el padre
     */
    public AdminController(Reception reception) {
        super(reception);
    }

    /**
     * crea un usuario administrador
     *
     * @param personalInformation Objeto que encapsula la informacion general de una persona
     * @return Administrator - Objeto de tipo Admnistrador
     */
    public Administrator create(PersonalInformation personalInformation) {
        return new Administrator(personalInformation);
    }

    public PersonalInformationController getPersonalInformationController() {
        return new PersonalInformationController();
    }
}
