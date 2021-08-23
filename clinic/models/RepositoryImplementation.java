package clinic.models;

import clinic.models.users.Nurse;
import clinic.models.users.Patient;
import clinic.models.users.Technician;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImplementation implements Repository {
    private List<MedicalHistoric> medicalHistorics;
    private List<MedicalHistoricStatistics> medicalHistoricStatistics;
    private List<Patient> patients;

    public RepositoryImplementation() {
        this.medicalHistoricStatistics = new ArrayList<>();
        this.medicalHistorics = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    @Override
    public List<Patient> getPatientList() {
        return this.patients;
    }

    @Override
    public Integer weekProcedureAmount(Nurse nurse, LocalDate localDate) {
        return null;
    }

    private List<MedicalHistoric> getMedicalHistorics() {
        return medicalHistorics;
    }

    private List<MedicalHistoricStatistics> getMedicalHistoricStatistics() {
        return medicalHistoricStatistics;
    }

    @Override
    public Integer weekProcedureAmount(Technician technician, LocalDate localDate) {
        return null;
    }
}
