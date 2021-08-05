package views;

import controllers.*;

public class OperationView extends ClinicView{

    public void interact(OperationController controller) {
        this.write();
        switch (this.getConsole().readInteger("Selecciona una opcion")){
            case 1:
                new ManagementUserView().interact(controller.getUserManagementController());
                break;
            case 2:
                new ManagementProcedureView().interact(controller.getManagementProcedureController());
                break;
            case 3:
                new ManagementInformationView().interact(controller.getManagmentInformationController());
                break;
            case 4:
            default:
                controller.exit();
                break;
        }
    }

    @Override
    protected void write() {
        this.writeConsole(" -- Menu Principal --");
        this.writeConsole("1 -- Gestion de Usuarios --");
        this.writeConsole("2 -- Gestion de Procesos Medicos --");
        this.writeConsole("3 -- Busquedas --");
        this.writeConsole("4 -- Salir --");
    }
}
