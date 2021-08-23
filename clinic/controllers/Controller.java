package clinic.controllers;

import clinic.models.Session;
import clinic.models.States;


/**
 * Abstract class Clinicas.Controlador - write a description of the class here
 *
 * @author: Date:
 */
public abstract class Controller {

    public Session getSession() {
        return Session.getInstance();
    }

    protected States getState() {
        return this.getSession().getState();
    }

    public void setState(States state) {
        this.getSession().setState(state);
    }

    public void exit() {
        this.setState(States.EXIT);
    }
}
