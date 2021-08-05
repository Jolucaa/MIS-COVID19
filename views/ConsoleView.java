package views;

import controllers.*;

public class ConsoleView implements MainView {
    private final ManagementUserView managementUserView;
    private final ManagementInformationView managementInformationView;
    private final ManagementProcedureView managementProcedureView;
    private final StartView startView;
    private final OperationView operationView;

    public ConsoleView() {
        this.startView = new StartView();
        this.operationView = new OperationView();
        this.managementUserView = new ManagementUserView();
        this.managementInformationView = new ManagementInformationView();
        this.managementProcedureView = new ManagementProcedureView();
    }

    public void interact(ViewVisitor visitor) {
        visitor.interact(this);
    }

    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    public void visit(OperationController operationController) {
        this.operationView.interact(operationController);
    }

    public void visit(ManagementUserController managementUserController) {
        this.managementUserView.interact(managementUserController);
    }

    public void visit(ManagmentInformationController managementController) {
        this.managementInformationView.interact(managementController);
    }

    public void visit(ManagementProcedureController managementProcedureController) {
        this.managementProcedureView.interact(managementProcedureController);
    }

    @Override
    public void visit(CreateNurseController createNurseController) {
        new CreateNurseView().interact(createNurseController);
    }

    @Override
    public void visit(PersonalInformationController personalInformationController) {
        new PersonalInformationView().interact(personalInformationController);
    }
}
