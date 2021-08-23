package clinic.models;

import clinic.models.users.Nurse;
import clinic.models.users.Patient;
import clinic.models.users.Technician;

import java.time.LocalDate;
import java.util.List;

public class RepositoryTechnician implements Repository {
    private RepositoryImplementation repositoryImplementation;

    public RepositoryTechnician() {
        super();
        this.repositoryImplementation = new RepositoryImplementation();
    }

    @Override
    public List<Patient> getPatientList() {
        return null;
    }

    @Override
    public Integer weekProcedureAmount(Nurse nurse, LocalDate localDate) {
        return null;
    }

    @Override
    public Integer weekProcedureAmount(Technician technician, LocalDate localDate) {
        return null;
    }


    private RepositoryImplementation getRepositoryImplementation() {
        return this.repositoryImplementation;
    }
}
