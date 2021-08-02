package views;

import controllers.UserManagementController;
import utils.Console;

public class UserManagementView extends ClinicView {

    public void interact(UserManagementController userManagementController) {
        this.write();
        userManagementController.control();
        switch (Console.getConsole().readInteger("Eliga una opcion: ")) {
            case 1:
                new CreateTechnicianView().interact(userManagementController.getCreateTechnicianController());
                break;
            case 2:
                new CreateNuerseView().interact(userManagementController.getCreateNurseController());
                break;
            case 3:
                new ManagementPatientView().interact(userManagementController.getManagementPatientController());
                break;
            case 4:
                new SwichUserView().interact(userManagementController.getSwitchUserController());
            case 5:
            default:
                this.restart(userManagementController);
                break;
        }
    }

    @Override
    protected void write() {
        this.writeConsole("--Menu de administracuion de usuarios--");
        this.writeConsole("1 Crear Tecnico/a");
        this.writeConsole("2 Crear Enfermero/a");
        this.writeConsole("3 Gestionar Pacientes");
        this.writeConsole("4 Cambiar Rol");
        this.writeConsole("5 Menu Principal");

    }
}
