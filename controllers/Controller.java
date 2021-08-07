package controllers;

import models.Reception;
import models.States;


/**
 * Abstract class Clinicas.Controlador - write a description of the class here
 *
 * @author: Date:
 */
public abstract class Controller {
    private Reception reception;

    protected Controller(Reception reception) {
        this.reception = reception;
    }

    protected States getState() {
        return this.getReception().getState();
    }

    public void setState(States state){
        this.getReception().setState(state);
    }

    protected Reception getReception(){
        return this.reception;
    }

    public void exit(){
        this.setState(States.EXIT);
    }

    public OperationController restart() {
        return new OperationController(this.getReception());
    }
}
