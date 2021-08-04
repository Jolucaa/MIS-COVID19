package models;

import java.util.Random;

/**
 * Write a description of class PCR here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PCR extends DiagnosticTest {
    Random random;
    /**
     * Constructor for objects of class PCR
     */
    public PCR(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
        random = new Random();
    }

    @Override
    public void accept(MedicalProcedureVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public DiagnosticTest diagnosticFamily(MedicalHistory medicalHistory) {
        return medicalHistory.diagnosticFamily(this);
    }

    @Override
    public Vaccine vaccineFamily(MedicalHistory medicalHistory) {
        return null;
    }

    @Override
    public ClinicError performMedicalProcedure() {
        if(random.nextBoolean()){
            this.getReceptorMedicalProcedure().addToMedicalHistory(this);
            this.setResult(true);
        }else{
            this.setResult(false);
        }
        return super.performMedicalProcedure();
    }

    @Override
    public void collect(DiagnosticTest diagnosticTest) {
        this.setMedicalSample(this.getSampleType());
    }

    protected MedicalSample getSampleType() {
        return MedicalSample.SMEAR;
    }

}
