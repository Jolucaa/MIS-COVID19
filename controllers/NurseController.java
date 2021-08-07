package controllers;

import models.PersonalInformation;
import models.Reception;

/**
 * Write a description of class NurseController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NurseController extends Controller {
    private PersonalInformationController personalInformationController;

    /**
     * Constructor for objects of class NurseController
     */
    public NurseController(Reception reception) {
        super(reception);
        this.personalInformationController = new PersonalInformationController(reception);
    }

    public void create(PersonalInformation personalInformation) {
        this.getReception().registerNurse(personalInformation);
    }

    public PersonalInformationController getPersonalInformationController() {
        return this.personalInformationController;
    }
}
