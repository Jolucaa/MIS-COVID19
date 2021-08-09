package models;

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
    public Technician(PersonalInformation personalInformation) {
        super(personalInformation);
    }

    @Override
    public Integer getId() {
        return this.getCollegiateNumber();
    }

    public boolean isAvailable() {
        Integer numberOfProceduresInOneWeek = 0;
        for (Patient patient : this.getPatientManager().getList()) {
            if (patient.getMedicalHistory().isEmpty()) {
                numberOfProceduresInOneWeek += patient.getProcedureInWeekWith(this, LocalDate.now());
            }
        }
        return numberOfProceduresInOneWeek < MAXIM_NUMBER_PROCEDURES_FOR_WEEK;
    }

}
