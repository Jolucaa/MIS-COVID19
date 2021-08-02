package models;

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
    protected ClinicError isError() {
        return null;
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
    public void collect(DiagnosticTest DiagnosticTest) {
        this.setMedicalSample(this.getMedicalSample());
    }
}
