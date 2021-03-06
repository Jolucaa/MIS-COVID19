package models;

import models.errors.ClinicError;
import models.errors.ErrorDiagnosticAnalyzerNotSet;
import models.errors.ErrorMedicalSampleNotCollected;

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
