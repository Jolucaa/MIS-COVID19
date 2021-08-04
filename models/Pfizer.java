package models;

/**
 * Write a description of class Pfizer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pfizer extends VaccineBiDose {

    /**
     * Constructor for objects of class Pfizer
     */
    public Pfizer(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    @Override
    public boolean accept(MedicalProcedureVisitor medicalProcedureVisitor) {
        return medicalProcedureVisitor.visit(this);
    }

    @Override
    public DiagnosticTest identify(MedicalHistory medicalHistory) {
        return null;
    }

    @Override
    public Vaccine vaccineFamily(MedicalHistory medicalHistory) {
        return this;
    }

    @Override
    public void accept(MedicalVaccineVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    protected Integer getVaccineDose() {
        return this.getReceptorMedicalProcedure().getVaccineDoseInjected(this.getClass().getSimpleName());
    }

    @Override
    protected ClinicError performVaccination() {
        if(this.canBeVaccinated()) {
            this.getReceptorMedicalProcedure().addToMedicalHistory(this);
            return null;
        }
        return new ErrorVaccinationError();
    }
    @Override
    protected boolean canBeVaccinated() {
        return this.getReceptorMedicalProcedure().isFulfillWithRequirements(this);
    }

    @Override
    public void subtractVaccineDose() {
        this.getWarehouseManager().remove(this.getNameArticle(), this);
    }

    @Override
    public String getNameArticle() {
        return this.getClass().toString();
    }

    @Override
    public Article getArticle() {
        return this;
    }
}
