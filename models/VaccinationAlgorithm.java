package models;

import java.time.LocalDate;

public class VaccinationAlgorithm {
    private MedicalHistory medicalHistory;

    public VaccinationAlgorithm(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean isFulfillWithRequirements(Pfizer vaccine) {
        if (this.isISameVaccineWichInitiated(Moderna.class.getSimpleName(), Johnson.class.getSimpleName())) {
            if (this.isTimeElapseToVaccinate(vaccine)) {
                medicalHistory.add(vaccine.getClass().toString(), vaccine);
                return true;
            }
        }

        return false;
    }

    public boolean isFulfillWithRequirements(Moderna vaccine) {
        if (this.isISameVaccineWichInitiated(Johnson.class.getSimpleName(), Pfizer.class.getSimpleName())) {
            if (this.isTimeElapseToVaccinate(vaccine)) {
                medicalHistory.add(vaccine.getClass().toString(), vaccine);
                return true;
            }
        }
        return false;
    }

    public boolean isFulfillWithRequirements(Johnson vaccine) {
        if (this.isISameVaccineWichInitiated(Moderna.class.getSimpleName(), Pfizer.class.getSimpleName())) {
            medicalHistory.add(vaccine.getClass().getSimpleName(), vaccine);
            return true;
        }
        return false;
    }


    protected boolean isISameVaccineWichInitiated(String firstVaccineExcluded, String secondVaccineExcluded) {
        return !(medicalHistory.contains(firstVaccineExcluded) || medicalHistory.contains(secondVaccineExcluded));
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

