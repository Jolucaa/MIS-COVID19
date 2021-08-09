package views;

import controllers.ManagementProcedureController;

public class ManagementProcedureView extends ClinicView {

    public void interact(ManagementProcedureController managementProcedureController) {
        new CreateVaccinationView().interact(managementProcedureController.getVaccinationController());
    }

    @Override
    protected void write() {
        this.writeConsole("--Gestion de Procesos Medicos--");
        this.writeConsole("1 Registrar prueba diagnostica");
        this.writeConsole("2 Actualizar pruebas diagnosticas");
        this.writeConsole("3 Registrar Vacunas");
        this.writeConsole("4 Actualizar las vacunas planificadas");
        this.writeConsole("5 Menu Principal");
    }
}
