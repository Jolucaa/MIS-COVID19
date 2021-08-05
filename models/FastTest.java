package models;

import models.errors.ClinicError;

/**
 * Write a description of class TestRapido here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FastTest extends AntigenTest {
    /**
     * Constructor for objects of class TestRapido
     */
    public FastTest(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    @Override
    public ClinicError accept(MedicalProcedureVisitor visitor) {
        visitor.visit(this);
        return null;
    }

    protected MedicalSample getSampleType() {
        return MedicalSample.BLOOD;
    }

    @Override
    public void collect(DiagnosticTest diagnosticTest) {
        this.setMedicalSample(this.getMedicalSample());
    }
}
