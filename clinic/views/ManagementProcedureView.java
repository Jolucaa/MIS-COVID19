package clinic.views;

public class ManagementProcedureView extends ClinicView {


    @Override
    public void write() {
        this.writeConsole("--Gestion de Procesos Medicos--");
        this.writeConsole("1 Registrar prueba diagnostica");
        this.writeConsole("2 Actualizar pruebas diagnosticas");
        this.writeConsole("3 Registrar Vacunas");
        this.writeConsole("4 Actualizar las vacunas planificadas");
        this.writeConsole("5 MainMenu Principal");
    }

    @Override
    public void interact() {
        //        TODO
    }
}
