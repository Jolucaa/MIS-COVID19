package views;

import controllers.PatientController;

public class ManagementPatientView extends ClinicView {

    public void interact(PatientController patientController) {
        this.write();
        switch (this.getConsole().readInteger("Seleccione un numero")) {
            case 1:
                new CreatePatientView().interact(patientController);
                break;
            case 2:
                this.writeList(patientController.showPatientsAvailable(), patientController);
                break;
            case 3:
                this.writeList(patientController.showPatientsAvailable(), patientController);
                break;
            case 4:
            default:
                this.restart(patientController);
        }
        this.getConsole().writeln();
    }

    @Override
    protected void write() {
        this.writeConsole("--Gestion de Pacientes--");
        this.writeConsole("1 Crear un Paciente");
        this.writeConsole("2 Modificar un Paciente");
        this.writeConsole("3 Eliminar un Paciente");
        this.writeConsole("4 Menu Principal");
    }
}
