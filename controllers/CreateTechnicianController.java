package controllers;


import models.*;

/**
 * Write a description of class newTechnicianController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreateTechnicianController extends Controller
{
    /**m
     * Construcor generico para instanciar la clase y guardar el objeto
     * Reception en el padre
     */
    public CreateTechnicianController(Reception reception) {
        super(reception);
    }

    @Override
    public ClinicError control(){
        return new ErrorAcces();
    }
    /**
     *
     * crea un usuario administrador
     *
     * @param personalInformation Objeto que encapsula la informacion general de una persona
     * @return the sum of x and y
     */
    public void create(PersonalInformation personalInformation) {
        this.getReception().registerTechnician(personalInformation);
    }
}
