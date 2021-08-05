package views;

import controllers.OperationController;
import controllers.StartController;

public interface PresentationView{

    void visit(StartController startController);

    void visit(OperationController operationController);
}
