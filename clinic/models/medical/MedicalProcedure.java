package clinic.models.medical;

import clinic.models.errors.ClinicError;

import java.time.LocalDate;

/**
 * Write a description of interface MedicalProcedure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public abstract class MedicalProcedure {
    private final LocalDate dateAssigned;
    private LocalDate dateRealization;
    private ReceptorMedicalProcedure receptorMedicalProcedure;
    private MedicalProcedureManager medicalProcedureManager;

    /*
     *
     *
     */
    protected MedicalProcedure(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        this.receptorMedicalProcedure = receptorMedicalProcedure;
        this.medicalProcedureManager = medicalProcedureManager;
        this.dateAssigned = LocalDate.now();
    }

    public abstract ClinicError performMedicalProcedure();

    public ReceptorMedicalProcedure getReceptorMedicalProcedure() {
        return this.receptorMedicalProcedure;
    }

    public LocalDate getDateAssigned() {
        return this.dateAssigned;
    }

    public LocalDate getDateRealization() {
        return this.dateRealization;
    }

    protected void setDateRealization(LocalDate dateRealization) {
        this.dateRealization = dateRealization;
    }

    public abstract ClinicError accept(MedicalProcedureVisitor medicalProcedureVisitor);

    public MedicalProcedureManager getMedicalProcedureManager() {
        return medicalProcedureManager;
    }

    public abstract void identifyFamily(IdentifierGenericFamily identifierGenericFamily);
}
