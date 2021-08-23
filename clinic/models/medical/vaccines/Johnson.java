package clinic.models.medical.vaccines;

import clinic.models.Item;
import clinic.models.errors.ClinicError;
import clinic.models.errors.ErrorVaccinationError;
import clinic.models.medical.MedicalProcedureManager;
import clinic.models.medical.MedicalProcedureVisitor;
import clinic.models.medical.ReceptorMedicalProcedure;

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
    public ClinicError accept(MedicalProcedureVisitor medicalProcedureVisitor) {
         return medicalProcedureVisitor.visit(this);
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
        ClinicError error = this.canBeVaccinated();
        if(error.isStackEmpty()) {
            this.getReceptorMedicalProcedure().addToMedicalHistory(this);
            return error;
        }
        error.add(new ErrorVaccinationError());
        return error;
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
    public Item getArticle() {
        return this;
    }


    protected ClinicError canBeVaccinated() {
        return this.getReceptorMedicalProcedure().canBeVaccinated(this);
    }

    @Override
    protected Integer getVaccineDose() {
        return this.getReceptorMedicalProcedure().getVaccineDoseInjected(this.getClass().getSimpleName());
    }
}
