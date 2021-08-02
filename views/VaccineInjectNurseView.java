package views;

import controllers.VaccinationNurseInjectController;
import models.MedicalProcedure;
import models.Patient;

import java.util.ArrayList;

public class VaccineInjectNurseView extends ClinicView{
    private ArrayList<MedicalProcedure> procedures;
    private VaccinationNurseInjectController vaccinationNurseInjectController;

    void interact(VaccinationNurseInjectController vaccinationNurseInjectController, Patient patient){
        this.vaccinationNurseInjectController = vaccinationNurseInjectController;
        this.procedures = this.vaccinationNurseInjectController.getMedicalProcessForPatient(patient);
    }

    protected void write(){
        int i = 0;
        for(MedicalProcedure medicalProcedure: this.procedures){
            this.writeConsole(i++ + " " + medicalProcedure.getClass().getName());
        }
        Integer procedureSelected = this.getConsole().readInteger("Selecciona un procedimiento");
        MedicalProcedure procedure = this.procedures.get(procedureSelected);
        this.vaccinationNurseInjectController.accept(procedure);
    }
}
