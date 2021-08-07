package models;
import controllers.*;
/**
 * Write a description of interface OperationController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface ControllerVisitor {

     void visit(StartController controller);

     void visit(AdminCreatorController controller);

     void visit(PatientController controller);

     void visit(ManagementProcedureController controller);

     void visit(SwitchUserController controller);

     void visit(OperationController controller);
}
