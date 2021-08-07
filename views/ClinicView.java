package views;

import controllers.Controller;
import models.Patient;
import models.Person;
import utils.Console;

import java.util.List;

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

    protected Patient getPatient() {
        return this.patient;
    }

    protected void setPatient(Patient patient) {
        this.patient = patient;
    }

    protected void restart(Controller controller) {
        controller.restart();
    }

    protected void writeList(List<? extends Patient> list, Controller controller) {
        if (!list.isEmpty()) {
            for (Person person : list) {
                this.writeConsole(list.listIterator().previousIndex() + " " + person.getId() + " " + person.getNameFormat());
            }
        } else {
            this.writeConsole("No se han encontrado registros");
            this.restart(controller);
        }
    }

    // hacerlo un visitor de view que sepa setear los valores de la clase
    protected Integer registerResponse() {
        return 0;
    }

}
