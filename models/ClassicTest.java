package models;

import models.errors.ClinicError;

/**
 * Write a description of class TestClasico here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClassicTest extends AntigenTest {

    /**
     * Constructor for objects of class TestClasico
     */
    public ClassicTest(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    @Override
    public ClinicError accept(MedicalProcedureVisitor visitor) {
        visitor.visit(this);
        return null;
    }

    @Override
    public void collect(DiagnosticTest diagnosticTest) {
        this.setMedicalSample(this.getMedicalSample());
    }
}
