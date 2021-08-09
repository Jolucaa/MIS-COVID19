package models;

import java.time.LocalDate;

/**
 * Write a description of class Nurse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nurse extends MedicalEmployee implements MedicalProcedureManager, MedicalSampleCollector, User {
    private final Integer MAXIM_NUMBER_PROCEDURES_FOR_WEEK = 5;

    /**
     * Constructor for objects of class Nurse
     */
    public Nurse(PersonalInformation personalInformation) {
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

    @Override
    public void collect(DiagnosticTest diagnosticTest) {
        diagnosticTest.collectMedicalSample(this);
    }
}
