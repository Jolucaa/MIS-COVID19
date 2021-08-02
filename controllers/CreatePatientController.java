package controllers;
import models.ClinicError;
import models.PersonalInformation;
import models.Reception;

/**
 * Write a description of class NewPatientController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreatePatientController extends Controller{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class NewPatientController
     */
    public CreatePatientController(Reception reception) {
        super(reception);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *
     *
     */
    public ClinicError control() {
        return null;
    }

    public void create(PersonalInformation personalInformation,Integer age, Integer SIP){
        this.getReception().registerPatient(personalInformation,age,SIP);
    }

}
