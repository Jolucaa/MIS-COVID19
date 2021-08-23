package clinic.models;

import clinic.models.medical.MedicalProcedure;
import clinic.models.medical.diagnostics.DiagnosticTest;
import clinic.models.medical.vaccines.Vaccine;

import java.util.ArrayList;
import java.util.List;

public class MedicalHistoricStatistics {

    private MedicalHistoric medicalHistoric;

    public MedicalHistoricStatistics(MedicalHistoric medicalHistoric) {
        assert medicalHistoric != null;
        this.medicalHistoric = medicalHistoric;
    }

    public boolean isLockdown() {
        return !this.searchLockdown().isEmpty();
    }

    protected List<DiagnosticTest> searchLockdown() {
        return getMedicalHistory().searchLockdown();
    }

    protected MedicalHistoric getMedicalHistory() {
        return medicalHistoric;
    }

    public List<MedicalProcedure> getPatientAvailableProcess() {
        ArrayList<MedicalProcedure> listOfProcedures = new ArrayList<>();
        listOfProcedures.addAll(this.getVaccineCanInject());
        listOfProcedures.addAll(this.getDiagnosticsCanDo());
        return listOfProcedures;
    }

    public List<DiagnosticTest> getDiagnosticsCanDo() {
        return this.getMedicalHistory().getDiagnosticsCanDo();
    }

    public List<Vaccine> getVaccineCanInject() {
        return this.getMedicalHistory().getVaccineCanInject();
    }
}
