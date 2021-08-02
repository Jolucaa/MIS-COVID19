package controllers;


import models.ClinicError;
import models.ErrorAcces;
import models.PersonalInformation;
import models.Reception;

/**
 * Write a description of class CreateNurseController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreateNurseController extends Controller
{
    /**
     * Constructor for objects of class CreateNurseController
     */
    public CreateNurseController(Reception reception)
    {
        super(reception);
    }

    @Override
    public ClinicError control() {
        ErrorAcces error = null;

        return error;
    }

    public void create(PersonalInformation personalInformation){
        this.getReception().registerNurse(personalInformation);
    }
}
