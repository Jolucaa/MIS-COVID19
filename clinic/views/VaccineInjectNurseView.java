package clinic.views;

import clinic.controllers.VaccinationController;
import clinic.models.medical.MedicalProcedure;
import clinic.models.medical.vaccines.Vaccine;
import clinic.models.users.Patient;

import java.util.List;

public class VaccineInjectNurseView extends ClinicView {
    private List<Vaccine> procedures;
    private VaccinationController vaccinationController;

    void interact(VaccinationController vaccinationController, Patient patient) {
        this.vaccinationController = vaccinationController;
        this.procedures = this.vaccinationController.getVaccineCanInject(patient);
    }

    public void write() {
        int i = 0;
        for (MedicalProcedure medicalProcedure : this.procedures) {
            this.writeConsole(i++ + " " + medicalProcedure.getClass().getSimpleName());
        }
        Integer procedureSelected = this.getConsole().readInteger("Selecciona un procedimiento");
        Vaccine procedure = this.procedures.get(procedureSelected);
        //requisitos??
        procedure.performMedicalProcedure();
    }

    @Override
    public void interact() {

    }
}
