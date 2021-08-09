package views.commands;

public class ExitLine extends MenuLine {
    private boolean exit = false;

    public boolean exit() {
        return exit;
    }

    @Override
    public String getTitle() {
        return "Salir";
    }

    @Override
    public void execute() {
        exit = true;
    }
}
