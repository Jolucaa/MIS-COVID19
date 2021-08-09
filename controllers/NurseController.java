package controllers;

import models.Nurse;
import models.PersonalInformation;
import models.Reception;

import java.util.List;

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
        this.personalInformationController = new PersonalInformationController();
    }

    public void create(PersonalInformation personalInformation) {
        this.getReception().registerNurse(personalInformation);
    }

    public List<Nurse> getNursesAvailables() {
        return this.getReception().getNursesAvailable();
    }

    public PersonalInformationController getPersonalInformationController() {
        return this.personalInformationController;
    }
}
