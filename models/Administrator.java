package models;

/**
 * Write a description of class Administrator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Administrator extends UserManager implements MedicalVaccineVisitor {

    /**
     * Constructor for objects of class Administrator
     */
    public Administrator(PersonalInformation personalInformation) {
        super(personalInformation);
    }

    @Override
    public void visit(PCR pcr) {

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
}
