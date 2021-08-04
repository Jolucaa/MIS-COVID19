package models;

import java.time.LocalDate;
import java.util.List;

/**
 * Abstract class Vaccine - write a description of the class here
 *
 * @author: Jose Luis Garcia Cabeza Date:
 */
public abstract class Vaccine extends MedicalProcedure implements Article {
    private final WarehouseManager warehouseManager;

    protected Vaccine(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
        this.warehouseManager = new WarehouseManager();
    }

    public ClinicError performMedicalProcedure() {
        ClinicError error = this.performVaccination();
        if(error != null) {
            this.setDateRealization(LocalDate.now());
            if (this.isCompleteVaccinationGuideline()) {
                this.subtractVaccineDose();
            }
        }
        return error;
    }

    protected abstract ClinicError performVaccination();

    protected abstract void subtractVaccineDose();

    protected abstract boolean canBeVaccinated();

    public abstract void accept(MedicalVaccineVisitor visitor);

    protected WarehouseManager getWarehouseManager() {
        return this.warehouseManager;
    }

    public abstract Integer getNecessaryVaccines();

    protected abstract Integer getVaccineDose();

    protected boolean isCompleteVaccinationGuideline() {
        return this.getNecessaryVaccines() <= this.getVaccineDose();
    }

}
