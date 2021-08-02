package controllers;
import models.ClinicError;
import models.States;
import views.ControllerViewVisitor;
import views.PresentationView;
import models.Reception;
import views.ViewVisitor;

public class OperationController extends Controller implements ViewVisitor {

    private UserManagementController userManagementController;
    private ManagementProcedureController managementProcedureController;
    private ManagmentInformationController managmentInformationController;

    public OperationController(Reception reception) {
        super(reception);
        this.userManagementController = new UserManagementController(this.getReception());
        this.managementProcedureController = new ManagementProcedureController(this.getReception());
        this.managmentInformationController = new ManagmentInformationController(this.getReception());
    }

    @Override
    public ClinicError control() {
        return null;
    }

    public void visit(PresentationView view) {
        view.visit(this);
    }

    public Controller getOperationController(){
        return this;
    }

    @Override
    public void interact(ControllerViewVisitor visitor) {
        visitor.visit(this);
    }


    public UserManagementController getUserManagementController() {
        this.setState(States.MANAGEMENT);
        return userManagementController;
    }

    public ManagementProcedureController getManagementProcedureController() {
        this.setState(States.MEDICAL_PROCESS);
        return managementProcedureController;
    }

    public ManagmentInformationController getManagmentInformationController() {
        this.setState(States.SEARCH);
        return managmentInformationController;
    }
}
