package models;

import java.time.LocalDate;

/**
 * Write a description of class Nurse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nurse extends MedicalEmployee implements MedicalProcedureManager, MedicalVaccineVisitor {
    private final Integer MAXIM_NUMBER_PROCEDURES_FOR_WEEK = 5;
    /**
     * Constructor for objects of class Nurse
     */
    public Nurse(PersonalInformation personalInformation) {
        super(personalInformation);
    }

    public boolean isNurseAvailable(){
        Integer numberOfProceduresInOneWeek = 0;
        for(Patient patient:this.getPatientManager().getArrayList()){
            if(patient.getMedicalHistory().isEmpty()){
                numberOfProceduresInOneWeek += patient.getProcedureInWeekWith(this,LocalDate.now());
            }
        }
        return numberOfProceduresInOneWeek < MAXIM_NUMBER_PROCEDURES_FOR_WEEK;
    }

    @Override
    public void visit(PCR pcr) {
        pcr.setDateRealization(LocalDate.now());
    }

    @Override
    public void visit(Pfizer pfizer) {

    }

    @Override
    public void visit(Moderna moderna) {

    }

    @Override
    public void visit(Johnson johnson) {

    }

    @Override
    public void visit(SerologicalAnalysis serologicalAnalysis) {

    }

    @Override
    public void visit(ClassicTest classicTest) {

    }

    @Override
    public void visit(FastTest fastTest) {

    }

    @Override
    public void collect(DiagnosticTest diagnosticTest) {
        diagnosticTest.collectMedicalSample(this);
    }
}
