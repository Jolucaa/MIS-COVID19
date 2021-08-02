package controllers;

import models.Administrator;
import models.ClinicError;
import models.PersonalInformation;
import models.Reception;

/**
 * Write a description of class AdminCreatorController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdminCreatorController extends Controller{
    /**m
     * Construcor generico para instanciar la clase y guardar el objeto
     * Reception en el padre
     */
    public AdminCreatorController(Reception reception) {
        super(reception);
    }

    /**
     * crea un usuario administrador
     *
     * @param personalInformation Objeto que encapsula la informacion general de una persona
     * @return the sum of x and y
     */
    public Administrator create(PersonalInformation personalInformation) {
        return new Administrator(personalInformation);
    }

    @Override
    public ClinicError control() {
        return null;
    }
}
