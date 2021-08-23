package clinic.views.menus.main;

import clinic.views.menus.Menu;


public class MainMenu extends Menu {

    @Override
    protected void addCommands() {
        this.add(new MenuManagementLine());
        this.add(new MenuProcedureLine());
        this.add(new MenuStatisticLine());
    }
}
