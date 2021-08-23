package clinic.views;

import clinic.controllers.ManagementMedicalEmployeeController;
import utils.Console;

public class ManagementMedicalEmployeeView extends ClinicView {

    public void interact() {
        ManagementMedicalEmployeeController managementMedicalEmployeeController = new ManagementMedicalEmployeeController();
        switch (Console.getConsole().readInteger("Elija una opcion: ")) {
            case 1:
                new CreateTechnicianView().interact();
                break;
            case 2:
                new CreateNurseView().interact();
                break;
        }

    }

    @Override
    public void write() {
        this.writeConsole("--MainMenu de gestion de empleados--");
        this.writeConsole("1 Crear Tecnico/a");
        this.writeConsole("2 Crear Enfermero/a");
        this.writeConsole("3 MainMenu Principal");

    }
}
