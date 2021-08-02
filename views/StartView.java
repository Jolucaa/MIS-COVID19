package views;
import controllers.StartController;
import utils.Console;
/**
 * Write a description of class StartView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartView {
    private AdminCreatorView adminCreatorView;
    private OperationView operationView;
    /**
     * Constructor for objects of class StartView
     */
    public StartView() {
        this.adminCreatorView = new AdminCreatorView();
        this.operationView = new OperationView();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param controller a sample parameter for a method
     * @return the sum of x and y
     */
    public void interact(StartController controller) {
        Console.getConsole().write("Clinica COVID-19");
        Console.getConsole().writeln();
        controller.start(this.adminCreatorView.interact());
    }
}
