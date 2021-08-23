package clinic.models.medical;

import clinic.models.errors.ClinicError;
import clinic.models.medical.vaccines.Vaccine;

/**
 * Write a description of interface ReceptorMedicalProcedure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface ReceptorMedicalProcedure{

    ClinicError canBeVaccinated(Vaccine vaccine);

    Integer getVaccineDoseInjected(String className);

    void addToMedicalHistory(MedicalProcedure medicalProcedure);

    boolean isLockdown();

    boolean isSIPMatch(Integer SIP);
}
