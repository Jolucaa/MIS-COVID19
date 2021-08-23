package clinic;

import clinic.controllers.OperationController;
import clinic.controllers.StartController;
import clinic.models.Session;
import clinic.views.ViewVisitor;

/**
 * Write a description of class Logica here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Logic {

    private final StartController startController;
    private final OperationController operationController;

    public Logic() {
        this.startController = new StartController();
        this.operationController = new OperationController();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return the sum of x and y
     */
    public ViewVisitor getController() {
        switch (Session.getInstance().getState()) {
            case INITIAL:
                return this.startController;
            case STARTED:
                return this.operationController;
            case EXIT:
            default:
                return null;
        }
    }
}
