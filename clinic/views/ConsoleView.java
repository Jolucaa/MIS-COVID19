package clinic.views;

import clinic.controllers.OperationController;
import clinic.controllers.StartController;

public class ConsoleView implements View {
    private final StartView startView;
    private final MainView mainView;

    public ConsoleView() {
        this.startView = new StartView();
        this.mainView = new MainView();
    }

    public void interact(ViewVisitor visitor) {
        visitor.interact(this);
    }

    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    public void visit(OperationController operationController) {
        this.mainView.interact(operationController);
    }
}
