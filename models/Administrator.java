package models;

import models.errors.ClinicError;

/**
 * Write a description of class Administrator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Administrator extends UserManager implements MedicalVaccineVisitor {
    private static Integer numInstance = 0;
    private final Integer identifier;
    /**
     * Constructor for objects of class Administrator
     */
    public Administrator(PersonalInformation personalInformation) {
        super(personalInformation);
        this.identifier = Administrator.numInstance++;
    }

    @Override
    public Integer getId() {
        return this.identifier;
    }

    @Override
    public void visit(PCR pcr) {

    }

    @Override
    public ClinicError visit(Pfizer pfizer) {

        return null;
    }

    @Override
    public ClinicError visit(Moderna moderna) {

        return null;
    }

    @Override
    public ClinicError visit(Johnson johnson) {

        return null;
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
}
