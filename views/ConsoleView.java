package views;

import controllers.*;
import views.commands.MenuOperation;

public class ConsoleView implements MainView {
    private final ManagementUserView managementUserView;
    private final ManagementInformationView managementInformationView;
    private final ManagementProcedureView managementProcedureView;
    private final StartView startView;
    private final OperationView operationView;
    private final ManagementMedicalEmployeeView managementMedicalEmployeeView;

    public ConsoleView() {
        this.startView = new StartView();
        this.operationView = new OperationView();
        this.managementUserView = new ManagementUserView();
        this.managementInformationView = new ManagementInformationView();
        this.managementProcedureView = new ManagementProcedureView();
        this.managementMedicalEmployeeView = new ManagementMedicalEmployeeView();
    }

    public void interact(ViewVisitor visitor) {
        visitor.interact(this);
    }

    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    public void visit(OperationController operationController) {
        this.operationView.interact(operationController);
        new MenuOperation().setView(this.operationView);
    }

    public void visit(ManagementUserController managementUserController) {
        this.managementUserView.interact(managementUserController);
    }

    public void visit(ManagementInformationController managementInformationController) {
        this.managementInformationView.interact(managementInformationController);
    }

    public void visit(ManagementProcedureController managementProcedureController) {
        this.managementProcedureView.interact(managementProcedureController);
    }

    @Override
    public void visit(ManagementMedicalEmployeeController managementMedicalEmployeeController) {
        this.managementMedicalEmployeeView.interact(managementMedicalEmployeeController);
    }
}
