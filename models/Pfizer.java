package models;

import models.errors.ClinicError;
import models.errors.ErrorVaccinationError;

/**
 * Write a description of class Pfizer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pfizer extends VaccineBiDose {

    /**
     * Constructor for objects of class Pfizer
     */
    public Pfizer(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    @Override
    public ClinicError accept(MedicalProcedureVisitor medicalProcedureVisitor) {
        return medicalProcedureVisitor.visit(this);
    }

    @Override
    protected Integer getVaccineDose() {
        return this.getReceptorMedicalProcedure().getVaccineDoseInjected(this.getClass().getSimpleName());
    }

    @Override
    protected ClinicError performVaccination() {
        ClinicError error = this.canBeVaccinated();
        if(error.isStackEmpty()) {
            this.getReceptorMedicalProcedure().addToMedicalHistory(this);
            return error;
        }
        error.add(new ErrorVaccinationError());
        return error;
    }
    @Override
    protected ClinicError canBeVaccinated() {
        return this.getReceptorMedicalProcedure().isFulfillWithRequirements(this);
    }

    @Override
    public void accept(MedicalVaccineVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void subtractVaccineDose() {
        this.getWarehouseManager().remove(this.getNameArticle(), this);
    }

    @Override
    public String getNameArticle() {
        return this.getClass().toString();
    }

    @Override
    public Item getArticle() {
        return this;
    }
}
