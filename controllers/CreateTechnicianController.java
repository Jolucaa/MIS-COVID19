package controllers;


import models.PersonalInformation;
import models.Reception;

/**
 * Write a description of class newTechnicianController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreateTechnicianController extends Controller {
    private PersonalInformationController personalInformationController;

    /**
     * m
     * Construcor generico para instanciar la clase y guardar el objeto
     * Reception en el padre
     */
    public CreateTechnicianController(Reception reception) {
        super(reception);
        this.personalInformationController = new PersonalInformationController(reception);
    }

    /**
     * Crea un técnico de laboratorio
     *
     * @param personalInformation - Objeto que encapsula la información general de una persona
     */
    public void create(PersonalInformation personalInformation) {
        this.getReception().registerTechnician(personalInformation);
    }

    public PersonalInformationController getPersonalInformationController() {
        return this.personalInformationController;
    }
}
