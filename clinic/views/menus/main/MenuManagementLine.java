package clinic.views.menus.main;

import clinic.views.ManagementUserView;
import clinic.views.menus.MenuLine;
import clinic.views.menus.main.management.MenuManagement;

public class MenuManagementLine extends MenuLine {
    public MenuManagementLine() {
        super("Gestion");
    }

    @Override
    public void execute() {
        MenuManagement menu = new MenuManagement();
        menu.execute(new ManagementUserView());
    }
}
