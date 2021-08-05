package controllers;

import models.PersonalInformation;
import models.Reception;
import views.MainView;
import views.PersonalInformationView;

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

    public void create(PersonalInformation personalInformation){
        this.getReception().registerNurse(personalInformation);
    }

    @Override
    public void interact(MainView viewVisitor) {
        viewVisitor.visit(this);
    }


}
