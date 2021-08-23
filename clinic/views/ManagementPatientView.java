package clinic.views;

import clinic.controllers.PatientController;

public class ManagementPatientView extends ClinicView {

    @Override
    public void interact() {
        PatientController patientController = new PatientController();
        switch (this.getConsole().readInteger("Seleccione un numero")) {
            case 1:
                new CreatePatientView().interact();
                break;
            case 2:
                this.writeList(patientController.showPatientsAvailable());
                break;
            case 3:
                this.writeList(patientController.showPatientsAvailable());
                break;
            case 4:
        }
        this.getConsole().writeln();
    }

    @Override
    public void write() {
        this.writeConsole("--Gestion de Pacientes--");
        this.writeConsole("1 Crear un Paciente");
        this.writeConsole("2 Modificar un Paciente");
        this.writeConsole("3 Eliminar un Paciente");
        this.writeConsole("4 MainMenu Principal");
    }
}
