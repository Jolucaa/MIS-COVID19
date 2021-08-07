package views;

import controllers.VaccinationController;
import models.MedicalProcedure;
import models.Patient;
import models.Vaccine;

import java.util.List;

public class VaccineInjectNurseView extends ClinicView {
    private List<Vaccine> procedures;
    private VaccinationController vaccinationController;

    void interact(VaccinationController vaccinationController, Patient patient) {
        this.vaccinationController = vaccinationController;
        this.procedures = this.vaccinationController.getVaccineCanInject(patient);
    }

    protected void write() {
        int i = 0;
        for (MedicalProcedure medicalProcedure : this.procedures) {
            this.writeConsole(i++ + " " + medicalProcedure.getClass().getSimpleName());
        }
        Integer procedureSelected = this.getConsole().readInteger("Selecciona un procedimiento");
        Vaccine procedure = this.procedures.get(procedureSelected);
        this.vaccinationController.accept(procedure);
    }

}
