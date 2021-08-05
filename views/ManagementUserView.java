package views;

import controllers.ManagementUserController;
import utils.Console;

public class ManagementUserView extends ClinicView {

    public void interact(ManagementUserController managementUserController) {
        this.write();
        managementUserController.control();
        switch (Console.getConsole().readInteger("Eliga una opcion: ")) {
            case 1:
                new CreateTechnicianView().interact(managementUserController.getCreateTechnicianController());
                break;
            case 2:
                new CreateNurseView().interact(managementUserController.getCreateNurseController());
                break;
            case 3:
                new ManagementPatientView().interact(managementUserController.getManagementPatientController());
                break;
            case 4:
                new SwichUserView().interact(managementUserController.getSwitchUserController());
                break;
            case 5:
            default:
                this.restart(managementUserController);
                break;
        }
    }

    @Override
    protected void write() {
        this.writeConsole("--Menu de administracion de usuarios--");
        this.writeConsole("1 Crear Tecnico/a");
        this.writeConsole("2 Crear Enfermero/a");
        this.writeConsole("3 Gestionar Pacientes");
        this.writeConsole("4 Cambiar Rol");
        this.writeConsole("5 Menu Principal");

    }
}
