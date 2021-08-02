package views;

import controllers.Controller;
import models.Patient;
import models.States;
import utils.Console;

public abstract class ClinicView {

    private Patient patient;

    protected abstract void write();

    protected void writeConsole(String title) {
        this.getConsole().write(title);
        this.getConsole().writeln();
    }

    protected Console getConsole() {
        return Console.getConsole();
    }

    protected void setPatient(Patient patient){
        this.patient = patient;
    }

    protected Patient getPatient(){
        return this.patient;
    }

    protected void restart(Controller controller){
        controller.setState(States.INITIAL);
        new OperationView().interact(controller.restart());
    }

}
