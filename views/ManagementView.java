package views;

import controllers.ManagementInformationController;
import controllers.ManagementMedicalEmployeeController;
import controllers.ManagementProcedureController;
import controllers.ManagementUserController;

public interface ManagementView {

    void visit(ManagementUserController managementUserController);

    void visit(ManagementInformationController managementInformationController);

    void visit(ManagementProcedureController managementProcedureController);

    void visit(ManagementMedicalEmployeeController managementMedicalEmployeeController);
}
