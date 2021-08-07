package models;

import models.errors.ClinicError;

import java.time.LocalDate;

/**
 * Abstract class Vaccine - write a description of the class here
 *
 * @author: Jose Luis Garcia Cabeza Date:
 */
public abstract class Vaccine extends MedicalProcedure implements Item {
    private final WarehouseManager warehouseManager;

    protected Vaccine(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
        this.warehouseManager = new WarehouseManager();
    }

    public ClinicError performMedicalProcedure() {
        ClinicError error = new ClinicError();
        error.add(this.performVaccination());
        if(error.isStackEmpty()) {
            this.setDateRealization(LocalDate.now());
            if (this.isCompleteVaccinationGuideline()) {
                this.subtractVaccineDose();
            }
        }
        return error;
    }


    @Override
    public void identifyFamily(IdentifierGenericFamily vaccineFamily){
        vaccineFamily.identify(this);
    }

    protected abstract ClinicError performVaccination();

    protected abstract void subtractVaccineDose();

    protected abstract ClinicError canBeVaccinated();

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
