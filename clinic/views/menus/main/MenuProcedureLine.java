package clinic.views.menus.main;

import clinic.views.ManagementUserView;
import clinic.views.menus.MenuLine;
import clinic.views.menus.main.management.procedures.MenuProcedure;

public class MenuProcedureLine extends MenuLine {
    public MenuProcedureLine() {
        super("Gestion Medica");
    }

    @Override
    public void execute() {
        MenuProcedure menu = new MenuProcedure();
        menu.execute(new ManagementUserView());
    }
}
