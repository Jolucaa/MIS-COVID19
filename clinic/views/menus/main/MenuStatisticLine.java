package clinic.views.menus.main;

import clinic.views.ManagementStatisticsView;
import clinic.views.menus.MenuLine;
import clinic.views.menus.main.management.statistics.MenuStatistic;

public class MenuStatisticLine extends MenuLine {
    public MenuStatisticLine() {
        super("Gestion Medica");
    }

    @Override
    public void execute() {
        MenuStatistic menu = new MenuStatistic();
        menu.execute(new ManagementStatisticsView());
    }
}
