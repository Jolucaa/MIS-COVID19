package controllers;
import models.*;

import java.util.ArrayList;

/**
 * Write a description of class SwitchUserController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SwitchUserController extends Controller{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class SwitchUserController
     */
    public SwitchUserController(Reception reception) {
        super(reception);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *
     *
     */
    @Override
    public ClinicError control() {
        return  null;
    }

    public void switchUser(Person person){

    }

    public Administrator getAdministrator(){
       return this.getReception().getAdministrator();
    }

    public ArrayList<Technician> getTechnicianList() {
        return this.getReception().getTechnicianList();
    }

    public ArrayList<Nurse> getNurseList() {
        return this.getReception().getNurseList();
    }

    public ArrayList<Patient> getPatientList() {
        return this.getReception().getPatientList();
    }

}
