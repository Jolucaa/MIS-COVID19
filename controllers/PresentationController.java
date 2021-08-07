package controllers;

import views.MainView;
import views.PresentationView;

public interface PresentationController {
    void accept(PresentationView view);

    void interact(MainView viewVisitor);
}
