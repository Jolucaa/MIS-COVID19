package clinic.models;

import clinic.models.users.Nurse;
import clinic.models.users.Patient;
import clinic.models.users.Technician;

import java.time.LocalDate;
import java.util.List;

public class RepositoryNurse implements Repository {
    private RepositoryImplementation repositoryImplementation;

    public RepositoryNurse() {
        super();
        this.repositoryImplementation = new RepositoryImplementation();
    }

    @Override
    public List<Patient> getPatientList() {
        return null;
    }

    @Override
    public Integer weekProcedureAmount(Nurse nurse, LocalDate localDate) {
        //TODO
        return null;
    }

    @Override
    public Integer weekProcedureAmount(Technician technician, LocalDate localDate) {
        //TODO
        return null;
    }


    private RepositoryImplementation getRepositoryImplementation() {
        return this.repositoryImplementation;
    }
}
