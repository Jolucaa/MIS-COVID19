package models;

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

    protected MedicalSample getSampleType() {
        return MedicalSample.BLOOD;
    }

    @Override
    public void collect(DiagnosticTest diagnosticTest) {
        this.setMedicalSample(this.getMedicalSample());
    }
}
