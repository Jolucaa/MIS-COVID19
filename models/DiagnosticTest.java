package models;

import java.time.LocalDate;
import java.util.Random;

/**
 * Abstract class DiagnosticTest - write a description of the class here
 *
 * @author: Date:
 */
public abstract class DiagnosticTest extends MedicalProcedure implements MedicalSampleCollector{
    private String medicalCenter;
    private Boolean result;
    private final Random random;
    private DiagnosticTestAnalyzer diagnosticTestAnalyzer;
    private MedicalSample medicalSample;

    protected DiagnosticTest(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
        random = new Random();
    }

    public void collectMedicalSample(MedicalSampleCollector collector) {
        this.setMedicalSample(this.getSampleType());
    }

    protected void setMedicalSample(MedicalSample medicalSample) {
        this.medicalSample = medicalSample;
    }

    protected abstract MedicalSample getSampleType();

    protected MedicalSample getMedicalSample() {
        return this.medicalSample;
    }

    protected boolean isMedicalSampleEmpty() {
        return this.getMedicalSample() != null;
    }

    protected Random getRandom(){
        return this.random;
    }

    public DiagnosticTestAnalyzer getDiagnosticTestAnalyzer() {
        return diagnosticTestAnalyzer;
    }

    protected void setDiagnosticTestAnalyzer(DiagnosticTestAnalyzer diagnosticTestAnalyzer) {
        this.diagnosticTestAnalyzer = diagnosticTestAnalyzer;
    }

    @Override
    public ClinicError performMedicalProcedure() {
        this.setDateRealization(LocalDate.now());
        return null;
    }

    public String getMedicalCenter() {
        return medicalCenter;
    }

    public void setMedicalCenter(String medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public boolean isPositive() {
        return result;
    }


    protected void setResult(Boolean result) {
        assert(result != null);
        this.result = result;
    }
}
