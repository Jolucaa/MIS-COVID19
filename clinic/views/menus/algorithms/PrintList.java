package clinic.views.menus.algorithms;

import clinic.models.filters.ParameterComposite;
import utils.Console;

import java.util.List;

public class PrintList {

    protected void writeList(List<ParameterComposite> list) {
        if (!list.isEmpty()) {
            for (ParameterComposite parameter : list) {
                this.writeConsole(list.listIterator().previousIndex() + " " + parameter.write() + " ");
            }
        } else {
            this.writeConsole("No se han encontrado registros");
        }
    }

    private void writeConsole(String title) {
        this.getConsole().write(title);
        this.getConsole().writeln();
    }

    protected Console getConsole() {
        return Console.getConsole();
    }
}
