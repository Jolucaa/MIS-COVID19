package views;

import controllers.*;

public interface OperationalView{

    void visit(UserManagementController userManagementController);

    void visit(ManagmentInformationController managmentController);

    void visit(ManagementProcedureController managementProcedureController);
}
