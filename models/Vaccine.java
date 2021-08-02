package models;

import java.time.LocalDate;

/**
 * Abstract class Vaccine - write a description of the class here
 *
 * @author: Date:
 */
public abstract class Vaccine extends MedicalProcedure implements Article {
    private final WarehouseManager warehouseManager;

    protected Vaccine(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
        this.warehouseManager = new WarehouseManager();
    }

    public ClinicError performMedicalProcedure() {
        if (this.isCompleteVaccinationGuideline()) {
            this.subtractVaccineDose();
        } else {
            this.performVaccination();
        }
        this.setDateRealization(LocalDate.now());
        return null;
    }

    protected abstract void performVaccination();

    protected abstract boolean isCompleteVaccinationGuideline();

    protected abstract void subtractVaccineDose();

    protected abstract boolean canBeVaccinated();

    public abstract void accept(MedicalVaccineVisitor visitor);

    protected WarehouseManager getWarehouseManager() {
        return this.warehouseManager;
    }

    public abstract Integer getNecessaryVaccines();

}
