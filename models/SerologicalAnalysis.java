package models;

import utils.IntegerLimited;


/**
 * Write a description of class SerologicalAnalysis here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SerologicalAnalysis extends DiagnosticTest {
    private final static int MIN_ANTIBODIES = 0;
    private final static int MAX_ANTIBODIES = 10;
    private final static int ALERT_ANTIBODIES = 2;
    private final IntegerLimited antibodies = new IntegerLimited(SerologicalAnalysis.MIN_ANTIBODIES, SerologicalAnalysis.MAX_ANTIBODIES);

    /**
     * Constructor for objects of class SerologicalAnalysis
     */
    public SerologicalAnalysis(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    @Override
    public boolean accept(MedicalProcedureVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public DiagnosticTest identify(MedicalHistory medicalHistory) {
        return medicalHistory.identify(this);
    }

    @Override
    public Vaccine vaccineFamily(MedicalHistory medicalHistory) {
        return null;
    }

    @Override
    public ClinicError performMedicalProcedure() {
        this.setResult(this.getAntibodies().set(this.getRandom().nextInt(SerologicalAnalysis.MAX_ANTIBODIES)) > SerologicalAnalysis.ALERT_ANTIBODIES);
        this.getReceptorMedicalProcedure().addToMedicalHistory(this);
        super.performMedicalProcedure();
        return this.isError();
    }

    @Override
    protected ClinicError isError() {
        return null;
    }

    public IntegerLimited getAntibodies() {
        return antibodies;
    }

    protected MedicalSample getSampleType() {
        return MedicalSample.SMEAR;
    }

    @Override
    public void collect(DiagnosticTest DiagnosticTest) {
        this.setMedicalSample(this.getSampleType());
    }
}
