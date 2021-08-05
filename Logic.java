import controllers.*;
import models.Reception;
import models.States;
import views.ViewVisitor;

/**
 * Write a description of class Logica here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Logic{

    private final Reception reception;
    private final StartController startController;
    private final OperationController operationController;
    private final ManagementUserController managementUserController;
    private final ManagmentInformationController managmentInformationController;
    private final ManagementProcedureController managementProcedureController;

    public Logic() {
        this.reception = new Reception();
        this.startController = new StartController(reception);
        this.operationController = new OperationController(reception);
        this.managementUserController = new ManagementUserController(reception);
        this.managmentInformationController = new ManagmentInformationController(reception);
        this.managementProcedureController = new ManagementProcedureController(reception);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return the sum of x and y
     */
    public ViewVisitor getController() {
        switch (this.getState()){
            case INITIAL:
                return this.startController;
            case STARTED:
                return this.operationController;
            case MANAGEMENT:
                return this.managementUserController;
            case MEDICAL_PROCESS:
                return this.managementProcedureController;
            case SEARCH:
                return this.managmentInformationController;
            case EXIT:
            default:
                return null;
        }
    }

    protected States getState(){
        return this.reception.getState();
    }

    public void setStates(States state){
        this.reception.setState(state);
    }
}
