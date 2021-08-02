package controllers;

import views.PresentationView;

public interface PresentatorVisitor {
    void accept(PresentationView controller);
}
