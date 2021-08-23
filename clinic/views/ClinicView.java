package clinic.views;

import clinic.views.menus.Menu;
import clinic.views.menus.Receptor;
import utils.Console;

import java.util.List;

public abstract class ClinicView implements Receptor {

    private Menu menu;

    public abstract void write();

    protected void writeConsole(String title) {
        this.getConsole().write(title);
        this.getConsole().writeln();
    }

    protected Console getConsole() {
        return Console.getConsole();
    }

    //TODO crear controlador filtro??
    protected void writeList(List<String> list) {
        if (!list.isEmpty()) {
            for (String string : list) {
                this.writeConsole(list.listIterator().previousIndex() + 1 + string);
            }
        } else {
            this.writeConsole("No se han encontrado registros");
        }
    }
}
