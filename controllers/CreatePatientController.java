package controllers;

import models.PersonalInformation;
import models.Reception;

/**
 * Write a description of class NewPatientController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreatePatientController extends Controller{

    private PersonalInformationController personalInformationController;

    /**
     * Constructor for objects of class NewPatientController
     */
    public CreatePatientController(Reception reception) {
        super(reception);
        this.personalInformationController = new PersonalInformationController(this.getReception());
    }

    public void create(PersonalInformation personalInformation, Integer SIP) {
        this.getReception().registerPatient(personalInformation, SIP);
    }

    public PersonalInformationController getPersonalInformationController() {
        return this.personalInformationController;
    }
}
