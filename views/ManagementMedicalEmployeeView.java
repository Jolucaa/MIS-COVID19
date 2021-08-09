package views;

import controllers.ManagementMedicalEmployeeController;
import utils.Console;

public class ManagementMedicalEmployeeView extends ClinicView {

    public void interact(ManagementMedicalEmployeeController managementMedicalEmployeeController) {
        switch (Console.getConsole().readInteger("Elija una opcion: ")) {
            case 1:
                new CreateTechnicianView().interact(managementMedicalEmployeeController.getTechnicianController());
                break;
            case 2:
                new CreateNurseView().interact(managementMedicalEmployeeController.getNurseController());
                break;
            case 3:
            default:
                this.restart(managementMedicalEmployeeController);
                break;
        }

    }

    @Override
    protected void write() {
        this.writeConsole("--Menu de gestion de empleados--");
        this.writeConsole("1 Crear Tecnico/a");
        this.writeConsole("2 Crear Enfermero/a");
        this.writeConsole("3 Menu Principal");

    }
}
