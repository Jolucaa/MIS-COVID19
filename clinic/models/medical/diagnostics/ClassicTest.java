package clinic.models.medical.diagnostics;

import clinic.models.errors.ClinicError;
import clinic.models.medical.MedicalProcedureManager;
import clinic.models.medical.MedicalProcedureVisitor;
import clinic.models.medical.ReceptorMedicalProcedure;

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
