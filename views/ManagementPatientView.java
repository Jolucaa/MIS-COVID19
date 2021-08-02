package views;

import controllers.ManagementPatientController;
import models.Patient;

import java.util.ArrayList;

public class ManagementPatientView extends ClinicView {

    public void interact(ManagementPatientController managementPatientController) {
        this.write();
        switch (this.getConsole().readInteger("Seleccione un numero")) {
            case 1:
                new CreatePatientView().interact(managementPatientController.getCreatePatientController());
                break;
            case 2:
                this.write(managementPatientController.showPatientsAvailable(), managementPatientController);
                break;
        }
        this.getConsole().writeln();
    }


    protected void write(ArrayList<Patient> patientArrayList, ManagementPatientController managementPatientController) {
        if (!patientArrayList.isEmpty()) {
            for (Patient patient : patientArrayList) {
                this.writeConsole(patientArrayList.listIterator().previousIndex() + " " + patient.getNameFormat() + " " + patient.getSIP());
            }
            Integer personSelected = this.getConsole().readInteger("Seleccione un paciente de la lista por su numero: ");
            Patient patient = patientArrayList.get(personSelected);
            this.setPatient(patient);
            this.write();
        }else{
            this.writeConsole("No hay pacientes registrados");
            this.restart(managementPatientController);
        }
    }

    @Override
    protected void write() {
        this.writeConsole("--Gestion de Usuarios--");
        this.writeConsole("1 Crear un Usuarios");
        this.writeConsole("2 seleccionar un Usuarios");

    }
}
