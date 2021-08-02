package models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Write a description of class Patient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patient extends Person implements ReceptorMedicalProcedure {
    // instance variables - replace the example below with your own
    private final MedicalHistory medicalHistory;
    private Integer age;
    private Integer SIP;

    /**
     * Constructor for objects of class Patient
     */
    public Patient(PersonalInformation personalInformation, Integer age, Integer SIP) {
        super(personalInformation);
        medicalHistory = new MedicalHistory();
        this.age = age;
        this.SIP = SIP;
    }

    public Integer getAge() {
        return age;
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

    protected ArrayList<DiagnosticTest> searchLockdown() {
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
    public boolean isFulfillWithRequirements(Vaccine vaccine) {
        return vaccine.accept(this.getMedicalHistory());
    }

    public Integer getProcedureInWeekWith(Nurse nurse, LocalDate date) {
        return this.getMedicalHistory().searchInThatWeek(date, nurse);
    }

    public Integer getProcedureInWeekWith(Technician technician, LocalDate date) {
        return this.getMedicalHistory().searchInThatWeek(date, technician);
    }

    public ArrayList<Vaccine> getVaccineCanInject() {
        return this.getMedicalHistory().getVaccineCanInject();
    }

    public Integer elapsedTimeConfined(){
       return this.getMedicalHistory().elapsedTimeConfined();
    }

    public ArrayList<MedicalProcedure> getMedicalProcessForPatient(){
        ArrayList<MedicalProcedure> listOfProcedures = new ArrayList<>();
        try {
            listOfProcedures.addAll(this.getMedicalHistory().getVaccineCanInject());
            listOfProcedures.addAll(this.getMedicalHistory().getDiagnosticsCanDo());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return listOfProcedures;
    }
}
