package views;

import controllers.*;

public interface ManagementView {

    void visit(ManagementUserController managementUserController);

    void visit(ManagementInformationController managementInformationController);

    void visit(ManagementProcedureController managementProcedureController);

    void visit(ManagementTechnicianController managementTechnicianController);
}
