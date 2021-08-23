package clinic.models;

import clinic.models.medical.vaccines.Johnson;
import clinic.models.medical.vaccines.Moderna;
import clinic.models.medical.vaccines.Pfizer;
import clinic.models.medical.vaccines.VaccineBiDose;

import java.time.LocalDate;

public class VaccinationAlgorithm {
    private MedicalHistoric medicalHistoric;

    public VaccinationAlgorithm(MedicalHistoric medicalHistoric) {
        this.medicalHistoric = medicalHistoric;
    }

    public boolean isFulfillWithRequirements(Pfizer vaccine) {
        if (this.isISameVaccineWichInitiated(Moderna.class.getSimpleName(), Johnson.class.getSimpleName())) {
            if (this.isTimeElapseToVaccinate(vaccine)) {
                medicalHistoric.add(vaccine.getClass().toString(), vaccine);
                return true;
            }
        }

        return false;
    }

    public boolean isFulfillWithRequirements(Moderna vaccine) {
        if (this.isISameVaccineWichInitiated(Johnson.class.getSimpleName(), Pfizer.class.getSimpleName())) {
            if (this.isTimeElapseToVaccinate(vaccine)) {
                medicalHistoric.add(vaccine.getClass().toString(), vaccine);
                return true;
            }
        }
        return false;
    }

    public boolean isFulfillWithRequirements(Johnson vaccine) {
        if (this.isISameVaccineWichInitiated(Moderna.class.getSimpleName(), Pfizer.class.getSimpleName())) {
            medicalHistoric.add(vaccine.getClass().getSimpleName(), vaccine);
            return true;
        }
        return false;
    }


    protected boolean isISameVaccineWichInitiated(String firstVaccineExcluded, String secondVaccineExcluded) {
        return !(medicalHistoric.contains(firstVaccineExcluded) || medicalHistoric.contains(secondVaccineExcluded));
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

