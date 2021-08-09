package views;

import controllers.ManagementUserController;
import utils.Console;

public class ManagementUserView extends ClinicView {

    public void interact(ManagementUserController managementUserController) {
        this.write();
        switch (Console.getConsole().readInteger("Eliga una opcion: ")) {
            case 1:
                new ManagementMedicalEmployeeView().interact(managementUserController.getManagementMedicalEmployeeController());
                break;
            case 2:
                new ManagementPatientView().interact(managementUserController.getPatientController());
                break;
            case 3:
                new SwitchUserView().interact(managementUserController.getSwitchUserController());
                break;
            case 4:
            default:
                this.restart(managementUserController);
                break;
        }
    }

    @Override
    protected void write() {
        this.writeConsole("--Menu de administracion de usuarios--");
        this.writeConsole("1 Gestionar Empleados");
        this.writeConsole("2 Gestionar Pacientes");
        this.writeConsole("3 Cambiar Rol");
        this.writeConsole("4 Menu Principal");

    }
}
