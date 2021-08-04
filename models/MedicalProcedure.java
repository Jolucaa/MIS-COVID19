package models;

import java.time.LocalDate;

/**
 * Write a description of interface MedicalProcedure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public abstract class MedicalProcedure {
    private LocalDate dateAssigned;
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

    protected LocalDate getDateRealization() {
        return this.dateRealization;
    }

    protected void setDateRealization(LocalDate dateRealization) {
        this.dateRealization = dateRealization;
    }

    protected boolean isFinished() {
        return this.getDateRealization() != null;
    }

    public abstract void accept(MedicalProcedureVisitor medicalProcedureVisitor);

    public MedicalProcedureManager getMedicalProcedureManager() {
        return medicalProcedureManager;
    }

    public abstract DiagnosticTest diagnosticFamily(MedicalHistory medicalHistory);

    public abstract Vaccine vaccineFamily(MedicalHistory medicalHistory);
}
