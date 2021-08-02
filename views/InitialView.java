package views;

import controllers.*;

public class InitialView implements ControllerViewVisitor, View{
    private final UserManagementView userManagementView;
    private final ManagmentView managmentView;
    private final ProceduresView proceduresView;
    private StartView startView;
    private OperationView operationView;
    private BackView backView;

    public InitialView() {
        this.startView = new StartView();
        this.operationView = new OperationView();
        this.backView = new BackView();
        this.userManagementView = new UserManagementView();
        this.managmentView = new ManagmentView();
        this.proceduresView = new ProceduresView();
    }

    public void interact(ControllerViewVisitor controller) {
        controller.interact(this);
    }

    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    public void visit(OperationController operationController) {
        this.operationView.interact(operationController);
    }

    public void visit(BackController backController) {
        this.backView.interact(backController);
    }


    public void visit(UserManagementController userManagementController) {
        this.userManagementView.interact(userManagementController);
    }

    public void visit(ManagmentInformationController managmentController) {
        this.managmentView.interact(managmentController);
    }

    public void visit(ManagementProcedureController managementProcedureController) {
        this.proceduresView.interact(managementProcedureController);
    }

    @Override
    public void interact(ViewVisitor controller) {
        controller.interact(this);
    }
}
