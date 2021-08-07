package controllers;

import views.MainView;
import views.ManagementView;

public interface ManagementController {

    void accept(ManagementView view);

    void interact(MainView viewVisitor);
}
