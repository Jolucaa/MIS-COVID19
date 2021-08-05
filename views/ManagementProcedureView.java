package views;

import controllers.ManagementProcedureController;
import models.Patient;

public class ManagementProcedureView extends ClinicView {

    public void interact(ManagementProcedureController managementProcedureController) {
        new CreateVaccinationView().interact(managementProcedureController.getCreateVaccinationController());
    }

    public void setPatient(Patient patient) {
        super.setPatient(patient);
    }

    @Override
    protected void write() {

    }
}
