package clinic.models.users;

import clinic.models.RepositoryNurse;
import clinic.models.medical.MedicalProcedureManager;
import clinic.models.medical.diagnostics.DiagnosticTest;
import clinic.models.medical.diagnostics.MedicalSampleCollector;

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
    public Nurse(PersonalData personalData) {
        super(personalData, new RepositoryNurse());
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

    @Override
    public void collect(DiagnosticTest diagnosticTest) {
        diagnosticTest.collectMedicalSample(this);
    }
}
