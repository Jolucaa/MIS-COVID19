package clinic.models.medical.vaccines;

import clinic.models.medical.MedicalProcedureManager;
import clinic.models.medical.ReceptorMedicalProcedure;

/**
 * Abstract class VaccineBiDose - write a description of the class here
 *
 * @author: Jose Luis Garcia Cabeza Date:
 */
public abstract class VaccineBiDose extends Vaccine {
    // instance variables - replace the example below with your own
    private final Long vaccinationInterval = VaccinationInformation.DAYS_BETWEEN_VACCINE;
    private final Integer necessaryVaccines = VaccinationInformation.BI_DOSE_NEEDED_VACCINES;

    /**
     * Constructor for objects of class VaccineBiDose
     */
    protected VaccineBiDose(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    public Integer getNecessaryVaccines() {
        return this.necessaryVaccines;
    }

    public Long getVaccinationInterval() {
        return this.vaccinationInterval;
    }

}
