package models;

/**
 * Write a description of interface ReceptorMedicalProcedure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface ReceptorMedicalProcedure{

    boolean isFulfillWithRequirements(Vaccine vaccine);

    Integer getVaccineDoseInjected(String className);

    void addToMedicalHistory(MedicalProcedure medicalProcedure);

    boolean isLockdown();

    boolean isSIPMatch(Integer SIP);
}
