package views;

import controllers.*;

public interface ManagementView {

    void visit(ManagementUserController managementUserController);

    void visit(ManagmentInformationController managementController);

    void visit(ManagementProcedureController managementProcedureController);
}
