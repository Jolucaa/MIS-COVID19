package views;

import controllers.SwitchUserController;
import models.User;
import utils.Console;

import java.util.Iterator;
import java.util.List;

public class SwitchUserView extends ClinicView {

    private SwitchUserController switchUserController;

    public void interact(SwitchUserController switchUserController) {
        this.switchUserController = switchUserController;

        this.write();

        switch (Console.getConsole().readInteger("Selecciona un numero: ")) {
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
            default:
                this.restart(switchUserController);
        }
    }

    private void showUserList(List<? extends User> personList) {
        Iterator<? extends User> iterator = personList.iterator();
        int personSelected = this.write(iterator);
        this.switchUser(personList.get(personSelected));
    }

    private void switchUser(User user) {
        this.switchUserController.switchUser(user);
    }

    private Integer write(Iterator<? extends User> iterator) {
        int counter = 0;
        while (iterator.hasNext()) {
            User user = iterator.next();
            this.writeConsole(counter++ + " " + user.getNameFormat());
        }
        return Console.getConsole().readInteger("Seleccione uno:");
    }

    @Override
    protected void write() {
        this.writeConsole("1 Administrador");
        this.writeConsole("2 Tecnico");
        this.writeConsole("3 Enfermero/a");
        this.writeConsole("4 Paciente");
    }

}
