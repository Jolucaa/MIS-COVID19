package models;

/**
 * Write a description of class Johnson here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Johnson extends Vaccine {
    /**
     * Constructor for objects of class Johnson
     */
    public Johnson(ReceptorMedicalProcedure receptorMedicalProcedure, MedicalProcedureManager medicalProcedureManager) {
        super(receptorMedicalProcedure, medicalProcedureManager);
    }

    @Override
    public void accept(MedicalProcedureVisitor medicalProcedureVisitor) {
        medicalProcedureVisitor.visit(this);
    }

    @Override
    public DiagnosticTest diagnosticFamily(MedicalHistory medicalHistory) {
        return null;
    }

    @Override
    public Vaccine vaccineFamily(MedicalHistory medicalHistory) {
        return medicalHistory.vaccineFamily(this);
    }

    @Override
    public void accept(MedicalVaccineVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Integer getNecessaryVaccines() {
        return VaccinationInformation.UNIQUE_NEEDED_VACCINES;
    }

    @Override
    public ClinicError performVaccination() {
        if(this.canBeVaccinated()) {
            this.getReceptorMedicalProcedure().addToMedicalHistory(this);
            return null;
        }
        return new ErrorVaccinationError();
    }

    @Override
    public void subtractVaccineDose() {
        this.getWarehouseManager().remove(this.getNameArticle(), this);
    }
    @Override
    public String getNameArticle() {
        return this.getClass().getSimpleName();
    }
    @Override
    public Article getArticle() {
        return this;
    }

    @Override
    protected boolean canBeVaccinated() {
        return this.getReceptorMedicalProcedure().isFulfillWithRequirements(this);
    }

    @Override
    protected Integer getVaccineDose() {
        return this.getReceptorMedicalProcedure().getVaccineDoseInjected(this.getClass().getSimpleName());
    }
}
