package views;

import controllers.SwitchUserController;
import models.Person;
import utils.Console;
import java.util.ArrayList;
import java.util.Iterator;

public class SwichUserView extends ClinicView{

    private SwitchUserController switchUserController;

    public void interact(SwitchUserController switchUserController) {
        this.switchUserController = switchUserController;

        this.writeConsole("1 Administrador");
        this.writeConsole("2 Tecnico");
        this.writeConsole("3 Enfermero/a");
        this.writeConsole("4 Paciente");

        switch (Console.getConsole().readInteger("Selecciona un numero: ")) {
            default:
            case 0:
                this.switchUser(switchUserController.getAdministrator());
                this.writeConsole(" Cambiado de tipo de usuaario a administrador satisfactoriamente");
                break;
            case 1:
                this.showUserList(switchUserController.getTechnicianList());
                this.writeConsole("Cambiado de tipo de usuaario a tecnico  satisfactoriamente");
                break;
            case 2:
                this.showUserList(switchUserController.getNurseList());

                this.writeConsole("Cambiado de tipo de usuaario a Enfermero/a  satisfactoriamente");
                break;
            case 3:
                this.showUserList(switchUserController.getPatientList());
                this.writeConsole("Cambiado de tipo de usuaario a Paciente  satisfactoriamente");
                break;
        }
    }

    private void showUserList(ArrayList personList) {
        Iterator iterator = personList.iterator();
        int personSelected = this.write(iterator);
        this.switchUser((Person) personList.get(personSelected));
    }

    private void switchUser(Person person) {
        this.switchUserController.switchUser(person);
    }

    private Integer write(Iterator iterator) {
        int counter = 0;
        while (iterator.hasNext()) {
            Person person = (Person) iterator.next();
            this.writeConsole(counter++ + " " + person.getNameFormat());
        }
        return Console.getConsole().readInteger("Seleccione uno:");
    }

    @Override
    protected void write() {

    }

}
