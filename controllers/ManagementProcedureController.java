package controllers;
import models.ClinicError;
import views.ControllerViewVisitor;
import views.OperationalView;
import models.Reception;
import views.ViewVisitor;

/**
 * Write a description of class ManagementProcedureController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ManagementProcedureController extends Controller implements ManagmentController, ViewVisitor {
    private CreateVaccinationController createVaccinationController;
    private VaccinationNurseInjectController vaccinationNurseInjectController;
    /**
     * Constructor for objects of class ManagementProcedureController
     */
    public ManagementProcedureController(Reception reception) {
        super(reception);
        this.vaccinationNurseInjectController = new VaccinationNurseInjectController(this.getReception());
        this.createVaccinationController = new CreateVaccinationController(this.getReception());
    }

    public void accept(OperationalView view) {
        view.visit(this);
    }

    @Override
    public void interact() {
        this.control();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *
     */
    public ClinicError control() {
        this.getReception().getMedicalProcessForPatient(this.getReception().getPatientList().get(0));
        return null;
    }

    @Override
    public void interact(ControllerViewVisitor viewVisitor) {
        viewVisitor.visit(this);
    }

    public CreateVaccinationController getCreateVaccinationController() {
        return createVaccinationController;
    }

    public VaccinationNurseInjectController getVaccinationNurseInjectController() {
        return vaccinationNurseInjectController;
    }
}
