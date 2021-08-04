package models;

import utils.IntegerLimited;


/**
 * Write a description of class SerologicalAnalysis here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SerologicalAnalysis extends DiagnosticTest {
    private static final Integer MIN_ANTIBODIES = 0;
    private static final Integer MAX_ANTIBODIES = 10;
    private static final Integer ALERT_ANTIBODIES = 2;
    private final IntegerLimited antibodies = new IntegerLimited(SerologicalAnalysis.MIN_ANTIBODIES, SerologicalAnalysis.MAX_ANTIBODIES);

    /**
     * Constructor for objects of class SerologicalAnalysis
     */
    public SerologicalAnalysis(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
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
        this.setResult(this.getAntibodies().set(this.getRandom().nextInt(SerologicalAnalysis.MAX_ANTIBODIES)) > SerologicalAnalysis.ALERT_ANTIBODIES);
        this.getReceptorMedicalProcedure().addToMedicalHistory(this);
        return super.performMedicalProcedure();
    }

    public IntegerLimited getAntibodies() {
        return antibodies;
    }

    protected MedicalSample getSampleType() {
        return MedicalSample.SMEAR;
    }

    @Override
    public void collect(DiagnosticTest diagnosticTest) {
        this.setMedicalSample(this.getSampleType());
    }
}
