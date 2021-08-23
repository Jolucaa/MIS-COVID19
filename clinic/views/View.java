package clinic.views;

import clinic.controllers.OperationController;
import clinic.controllers.StartController;

/**
 * Write a description of class Vista here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * Se encarga de unificar el codigo repetido de las vistas especificas
 */
public interface View {
    void interact(ViewVisitor viewVisitor);

    void visit(StartController startController);

    void visit(OperationController operationController);
}
