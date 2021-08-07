package controllers;

import models.*;
import views.MainView;

import java.util.List;

/**
 * Write a description of class SwitchUserController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SwitchUserController extends Controller {

    /**
     * Constructor for objects of class SwitchUserController
     */
    public SwitchUserController(Reception reception) {
        super(reception);
    }

//    public void switchUser(User user){
//        this.getReception().setUser(user);
//    }

    public Administrator getAdministrator() {
        return this.getReception().getAdministrator();
    }

    public List<Technician> getTechnicianList() {
        return this.getReception().getTechnicianList();
    }

    public List<Nurse> getNurseList() {
        return this.getReception().getNurseList();
    }

    public List<Patient> getPatientList() {
        return this.getReception().getPatientList();
    }

    @Override
    public void interact(MainView viewVisitor) {

    }
}
