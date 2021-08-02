package models;

import java.time.LocalDate;

public class VaccinationAlghoritm {
    private MedicalHistory medicalHistory;

    public VaccinationAlghoritm(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean isFulfillWithRequirements(Pfizer vaccine) {
        if (this.isGuidelineVaccinationComplete(vaccine)) {
        if (this.isISameVaccineWichInitiated(Moderna.class.toString(), Johnson.class.toString())) {
            if (this.isTimeElapseToVaccinate(vaccine)) {
                medicalHistory.add(vaccine.getClass().toString(), vaccine);
                return true;
            }
        }
    }
        return false;
    }

    public boolean isFulfillWithRequirements(Moderna vaccine) {
        if(this.isGuidelineVaccinationComplete(vaccine)) {
            if (this.isISameVaccineWichInitiated(Johnson.class.toString(), Pfizer.class.toString())) {
                if (this.isTimeElapseToVaccinate(vaccine)) {
                    medicalHistory.add(vaccine.getClass().toString(), vaccine);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFulfillWithRequirements(Johnson vaccine) {
        if(this.isGuidelineVaccinationComplete(vaccine)) {
            if (this.isISameVaccineWichInitiated(Moderna.class.toString(), Pfizer.class.toString())) {
                medicalHistory.add(vaccine.getClass().toString(), vaccine);
                return true;
            }
        }
        return false;
    }


    protected boolean isISameVaccineWichInitiated(String firstVaccineExcluded, String secondVaccineExcluded) {
        return !(medicalHistory.contains(firstVaccineExcluded) || medicalHistory.contains(secondVaccineExcluded));
    }

    protected boolean isGuidelineVaccinationComplete(Vaccine vaccine) {
        return medicalHistory.sizeOfMedicalProcedure(vaccine.toString()) <= vaccine.getNecessaryVaccines();
    }

    protected boolean isTimeElapseToVaccinate(VaccineBiDose vaccine) {
        LocalDate vaccineInjectionTime = this.calculateVaccineInterval(vaccine.getVaccinationInterval());
        long days = new Calendar().durationBetweenDays(vaccine.getDateRealization(), vaccineInjectionTime);
        return days >= vaccine.getVaccinationInterval();
    }

    protected LocalDate calculateVaccineInterval(long days) {
        return LocalDate.now().plusDays(days);
    }
}

