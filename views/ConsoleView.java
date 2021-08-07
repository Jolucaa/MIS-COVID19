package views;

import controllers.*;

public class ConsoleView implements MainView {
    private final ManagementUserView managementUserView;
    private final ManagementInformationView managementInformationView;
    private final ManagementProcedureView managementProcedureView;
    private final StartView startView;
    private final OperationView operationView;
    private final ManagementMedicalEmployeeView managementMedicalEmployeeView;
    private final PersonalInformationView personalInformationView;
    private final CreateNurseView createNurseView;
    private final CreatePatientView createPatientView;
    private final CreateVaccinationView createVaccinationView;
    private final CreateTechnicianView createTechnicianView;
    private final DiagnosticTestViewer diagnosticTestViewer;

    public ConsoleView() {
        this.startView = new StartView();
        this.operationView = new OperationView();
        this.managementUserView = new ManagementUserView();
        this.managementInformationView = new ManagementInformationView();
        this.managementProcedureView = new ManagementProcedureView();
        this.managementMedicalEmployeeView = new ManagementMedicalEmployeeView();
        this.personalInformationView = new PersonalInformationView();
        this.createNurseView = new CreateNurseView();
        this.createPatientView = new CreatePatientView();
        this.createTechnicianView = new CreateTechnicianView();
        this.createVaccinationView = new CreateVaccinationView();
        this.diagnosticTestViewer = new DiagnosticTestViewer();
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

    @Override
    public void visit(NurseController nurseController) {
        this.createNurseView.interact(nurseController);
    }

    @Override
    public void visit(PersonalInformationController personalInformationController) {
        this.personalInformationView.interact(personalInformationController);
    }

    @Override
    public void visit(CreatePatientController createPatientController) {
        this.createPatientView.interact(createPatientController);
    }

    @Override
    public void visit(TechnicianController technicianController) {
        this.createTechnicianView.interact(technicianController);
    }

    @Override
    public void visit(CreateVaccinationController vaccinationController) {
        this.createVaccinationView.interact(vaccinationController);
    }

    @Override
    public void visit(DiagnosticTestController diagnosticTestController) {
        this.diagnosticTestViewer.interact(diagnosticTestController);
    }
}
