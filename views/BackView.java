package views;
import controllers.BackController;
import utils.Console;
public class BackView{
    public void interact(BackController controller) {
        Console.getConsole().write("Vista BackView");
        Console.getConsole().writeln();
    }
}
