package clinic.models;

import clinic.models.users.Nurse;
import clinic.models.users.Patient;
import clinic.models.users.Technician;

import java.time.LocalDate;
import java.util.List;

public interface Repository {

    List<Patient> getPatientList();

    Integer weekProcedureAmount(Nurse nurse, LocalDate localDate);

    Integer weekProcedureAmount(Technician technician, LocalDate localDate);

}
