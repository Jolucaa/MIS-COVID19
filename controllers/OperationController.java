package controllers;

import models.Reception;
import models.States;
import views.MainView;
import views.PresentationView;

public class OperationController extends Controller implements PresentationController {

    private ManagementUserController managementUserController;
    private ManagementProcedureController managementProcedureController;
    private ManagementInformationController managementInformationController;

    public OperationController(Reception reception) {
        super(reception);
        this.managementUserController = new ManagementUserController(this.getReception());
        this.managementProcedureController = new ManagementProcedureController(this.getReception());
        this.managementInformationController = new ManagementInformationController(this.getReception());
    }

    public void accept(PresentationView view) {
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

    public ManagementInformationController getManagementInformationController() {
        this.setState(States.SEARCH);
        return managementInformationController;
    }
}
