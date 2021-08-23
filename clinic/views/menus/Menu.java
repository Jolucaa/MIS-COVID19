package clinic.views.menus;

import clinic.models.errors.ErrorIntegerOutOfBounds;
import utils.Console;
import utils.IntegerLimited;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    private List<MenuLine> menuLines;
    private ExitLine exitCommand = new ExitLine();

    protected Menu() {
        this.menuLines = new ArrayList<>();
        this.addCommands();
        this.add(this.exitCommand);
    }

    protected abstract void addCommands();

    protected void add(MenuLine menuLine) {
        this.getMenuCommands().add(menuLine);
    }

    private List<MenuLine> getMenuCommands() {
        return menuLines;
    }

    public void execute(Receptor receptor) {
        this.set(receptor);
        do {
            this.write();
            Integer selectedOption = this.readOption();
            this.getMenuCommands().get(selectedOption).execute();
        } while (this.exitCommand.isClosed());
    }

    public void set(Receptor receptor) {
        for (MenuLine command : this.getMenuCommands()) {
            command.setReceptor(receptor);
        }
    }

    protected void write() {
        for (int i = 0; i <= this.getMenuCommands().size(); i++) {
            this.writeConsole(i + ": " + this.getMenuCommands().get(i).getTitle());
        }
    }

    private void writeConsole(String title) {
        this.getConsole().write(title);
        this.getConsole().writeln();
    }

    protected Console getConsole() {
        return Console.getConsole();
    }

    private Integer readOption() {
        Integer option;
        option = this.getConsole().readInteger("Selecciona una opcion");
        if (new IntegerLimited(1, this.getMenuCommands().size() - 1).check(option)) {
            this.writeConsole(new ErrorIntegerOutOfBounds().buildErrorTrace());
            this.readOption();
        }
        return option;
    }
}
