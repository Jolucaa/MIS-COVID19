package clinic.controllers;

import clinic.models.users.PersonalData;

import java.util.List;

/**
 * Write a description of class NurseController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NurseController extends Controller {
    private NurseManager nurseManager;

    /**
     * Constructor for objects of class NurseController
     */
    public NurseController() {
        this.nurseManager = new NurseManager();
    }

    public void create(PersonalData personalData) {
        this.getNurseManager().create(personalData);
    }

    private NurseManager getNurseManager() {
        return nurseManager;
    }

    public List<String> getNursesAvailables() {
        //return this.getNurseManager().getNursesAvailable();
        //TODO Pasar a string
        return null;
    }
}
