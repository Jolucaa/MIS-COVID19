package clinic.models.medical.diagnostics;

import clinic.models.errors.ClinicError;
import clinic.models.errors.ErrorDiagnosticAnalyzerNotSet;
import clinic.models.errors.ErrorMedicalSampleNotCollected;
import clinic.models.medical.MedicalProcedureManager;
import clinic.models.medical.ReceptorMedicalProcedure;

/**
 * Abstract class PruebasAntigenos - write a description of the class here
 *
 * @author: Date:
 */
public abstract class AntigenTest extends DiagnosticTest {

    protected AntigenTest(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    protected MedicalSample getSampleType() {
        return MedicalSample.SMEAR;
    }

    @Override
    public ClinicError performMedicalProcedure() {
        if(this.getDiagnosticTestAnalyzer() != null) {
            if (!isMedicalSampleEmpty()) {
                if (this.getRandom().nextBoolean()) {
                    this.getReceptorMedicalProcedure().addToMedicalHistory(this);
                    this.setResult(true);
                } else {
                    this.setResult(false);
                }
                return super.performMedicalProcedure();
            } else {
                return new ErrorMedicalSampleNotCollected();
            }
        }
        return new ErrorDiagnosticAnalyzerNotSet();
    }

}
