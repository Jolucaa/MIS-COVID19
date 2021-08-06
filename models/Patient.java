package models;

import models.errors.ClinicError;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Write a description of class Patient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patient extends Person implements ReceptorMedicalProcedure {

    private static Integer numInstance = 0;
    private final MedicalHistory medicalHistory;
    private final Random random = new Random();
    private Integer identifier;
    private Integer SIP;

    /**
     * Constructor for objects of class Patient
     */
    public Patient(PersonalInformation personalInformation) {
        super(personalInformation);
        medicalHistory = new MedicalHistory();
        this.SIP = this.random.nextInt(7);
        this.identifier = Patient.numInstance++;
    }

    /**
     * Constructor for objects of class Patient
     */
    public Patient(PersonalInformation personalInformation, Integer SIP) {
        this(personalInformation);
        this.SIP = SIP;
    }


    public Integer getSIP() {
        return SIP;
    }

    public boolean isSIPMatch(Integer SIP) {
        return this.getSIP().equals(SIP);
    }

    @Override
    public boolean isLockdown() {
        return !this.searchLockdown().isEmpty();
    }

    protected List<DiagnosticTest> searchLockdown() {
        return getMedicalHistory().searchLockdown();
    }

    protected MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    @Override
    public Integer getVaccineDoseInjected(String className) {
        return this.getMedicalHistory().sizeOfMedicalProcedure(className);
    }

    @Override
    public void addToMedicalHistory(MedicalProcedure medicalProcedure) {
        this.getMedicalHistory().add(medicalProcedure.getClass().toString(), medicalProcedure);
    }

    @Override
    public ClinicError isFulfillWithRequirements(Vaccine vaccine) {
        ClinicError error = new ClinicError();
         error.add(vaccine.accept(this.getMedicalHistory()));
         return error;
    }

    public Integer getProcedureInWeekWith(Nurse nurse, LocalDate date) {
        return this.getMedicalHistory().searchInThatWeek(date, nurse);
    }

    public Integer getProcedureInWeekWith(Technician technician, LocalDate date) {
        return this.getMedicalHistory().searchInThatWeek(date, technician);
    }

    public List<Vaccine> getVaccineCanInject() {
        return this.getMedicalHistory().getVaccineCanInject();
    }

    public Integer elapsedTimeConfined() {
        return this.getMedicalHistory().elapsedTimeConfined();
    }

    public List<MedicalProcedure> getMedicalProcessForPatient() {
        ArrayList<MedicalProcedure> listOfProcedures = new ArrayList<>();
        listOfProcedures.addAll(this.getVaccineCanInject());
        listOfProcedures.addAll(this.getDiagnosticsCanDo());
        return listOfProcedures;
    }

    public List<DiagnosticTest> getDiagnosticsCanDo() {
        return this.getMedicalHistory().getDiagnosticsCanDo();
    }

    @Override
    public Integer getId() {
        return this.identifier;
    }
}
