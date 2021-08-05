package controllers;
import models.States;
import views.MainView;
import views.PresentationView;
import models.Reception;

public class OperationController extends Controller {

    private ManagementUserController managementUserController;
    private ManagementProcedureController managementProcedureController;
    private ManagmentInformationController managmentInformationController;

    public OperationController(Reception reception) {
        super(reception);
        this.managementUserController = new ManagementUserController(this.getReception());
        this.managementProcedureController = new ManagementProcedureController(this.getReception());
        this.managmentInformationController = new ManagmentInformationController(this.getReception());
    }
    public void visit(PresentationView view) {
        view.visit(this);
    }

    public Controller getOperationController(){
        return this;
    }

    @Override
    public void interact(MainView visitor) {
        visitor.visit(this);
    }


    public ManagementUserController getUserManagementController() {
        this.setState(States.MANAGEMENT);
        return managementUserController;
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
