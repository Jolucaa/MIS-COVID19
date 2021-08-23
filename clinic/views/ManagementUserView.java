package clinic.views;

import utils.Console;

public class ManagementUserView extends ClinicView {

    @Override
    public void interact() {
        this.write();
        switch (Console.getConsole().readInteger("Eliga una opcion: ")) {
            case 1:
                new ManagementMedicalEmployeeView().interact();
                break;
            case 2:
                new ManagementPatientView().interact();
                break;
            case 3:
                new SwitchUserView().interact();
                break;
        }
    }

    @Override
    public void write() {
        this.writeConsole("--MainMenu de administracion de usuarios--");
        this.writeConsole("1 Gestionar Empleados");
        this.writeConsole("2 Gestionar Pacientes");
        this.writeConsole("3 Cambiar Rol");
        this.writeConsole("4 MainMenu Principal");

    }
}
