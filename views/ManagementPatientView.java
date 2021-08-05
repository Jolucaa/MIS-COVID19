package views;

import controllers.ManagementPatientController;

public class ManagementPatientView extends ClinicView {

    public void interact(ManagementPatientController managementPatientController) {
        this.write();
        switch (this.getConsole().readInteger("Seleccione un numero")) {
            case 1:
                new CreatePatientView().interact(managementPatientController.getCreatePatientController());
                break;
            case 2:
                this.writePatientList(managementPatientController.showPatientsAvailable(), managementPatientController);
                break;
            default:
                this.restart(managementPatientController);
        }
        this.getConsole().writeln();
    }

    @Override
    protected void write() {
        this.writeConsole("--Gestion de Usuarios--");
        this.writeConsole("1 Crear un Usuario");
        this.writeConsole("2 Seleccionar un Usuario");
    }
}
