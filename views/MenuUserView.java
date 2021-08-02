package views;

import controllers.*;

public interface MenuUserView extends View{

    void visit(ManagmentTechnicianController managmentTechnicianController);

    void visit(ManagmentNurseController managmentNurseController);

    void visit(UserManagementController userManagementController);
}
