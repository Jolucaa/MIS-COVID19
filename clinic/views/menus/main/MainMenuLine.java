package clinic.views.menus.main;

import clinic.views.MainView;
import clinic.views.menus.MenuLine;

public class MainMenuLine extends MenuLine {
    public MainMenuLine() {
        super("Menu Principal");
    }

    @Override
    public void execute() {
        MainMenu menu = new MainMenu();
        menu.execute(new MainView());
    }
}
