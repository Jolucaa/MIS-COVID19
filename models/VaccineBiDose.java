package models;

/**
 * Abstract class VaccineBiDose - write a description of the class here
 *
 * @author: Date:
 */
public abstract class VaccineBiDose extends Vaccine {
    // instance variables - replace the example below with your own
    private final Long vaccinationInterval = VaccinationInformation.DAYS_BETWEEN_VACCINE;
    private final Integer necessaryVaccines = VaccinationInformation.BIDOSE_NEEDED_VACCINES;

    /**
     * Constructor for objects of class VaccineBiDose
     */
    public VaccineBiDose(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    public Integer getNecessaryVaccines() {
        return this.necessaryVaccines;
    }

    protected abstract Integer getVaccineDose();

    protected Long getVaccinationInterval() {
        return this.vaccinationInterval;
    }

    protected boolean isCompleteVaccinationGuideline() {
         if(this.canBeVaccinated()){
             return this.getNecessaryVaccines().equals(this.getVaccineDose());
         }
         return false;
    }

}