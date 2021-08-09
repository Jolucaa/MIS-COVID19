package views;

import controllers.ManagementInformationController;

public class ManagementInformationView extends ClinicView {
    public void interact(ManagementInformationController managementInformationController) {

    }

    @Override
    protected void write() {
        this.writeConsole("--Consultas--");
        this.writeConsole("1 Consultas Paciente");
        this.writeConsole("2 Consultas Empleados");
        this.writeConsole("3 Consultas Vacunas");
        this.writeConsole("4 Menu Principal");
    }
}
