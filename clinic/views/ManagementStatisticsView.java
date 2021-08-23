package clinic.views;

public class ManagementStatisticsView extends ClinicView {

    @Override
    public void write() {
        this.writeConsole("--Consultas--");
        this.writeConsole("1 Consultas Paciente");
        this.writeConsole("2 Consultas Empleados");
        this.writeConsole("3 Consultas Vacunas");
        this.writeConsole("4 MainMenu Principal");
    }

    @Override
    public void interact() {

    }
}
