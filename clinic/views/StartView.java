package clinic.views;

import clinic.controllers.StartController;
import utils.Console;

/**
 * Write a description of class StartView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartView {
    /**
     * An example of a method - replace this comment with your own
     *
     * @param startController a sample parameter for a method
     */
    public void interact(StartController startController) {
        Console.getConsole().write("Clinica COVID-19");
        Console.getConsole().writeln();
        startController.start(new AdminCreatorView().interact(startController.getAdminCreatorController()));
    }
}
