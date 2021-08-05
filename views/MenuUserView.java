package views;

import controllers.*;

public interface MenuUserView extends View{

    void visit(ManagmentTechnicianController managmentTechnicianController);

    void visit(ManagementNurseController managmentNurseController);

    void visit(ManagementUserController managementUserController);
}
