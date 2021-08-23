package clinic.models.users;

import clinic.models.RepositoryTechnician;
import clinic.models.medical.diagnostics.DiagnosticTestAnalyzer;

import java.time.LocalDate;

/**
 * Write a description of class Technician here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Technician extends MedicalEmployee implements DiagnosticTestAnalyzer, User {

    private final Integer MAXIM_NUMBER_PROCEDURES_FOR_WEEK = 4;

    /**
     * Constructor for objects of class Technician
     */
    public Technician(PersonalData personalData) {
        super(personalData, new RepositoryTechnician());
    }

    @Override
    public Integer getId() {
        return this.getCollegiateNumber();
    }

    public boolean isAvailable() {
        Integer numberOfProceduresInOneWeek = 0;
        for (Patient patient : this.getRepository().getPatientList()) {
            if (!patient.getMedicalHistory().isEmpty()) {
                numberOfProceduresInOneWeek += this.getRepository().weekProcedureAmount(this, LocalDate.now());
            }
        }
        return numberOfProceduresInOneWeek < MAXIM_NUMBER_PROCEDURES_FOR_WEEK;
    }

}
