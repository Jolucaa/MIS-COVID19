package controllers;

import views.PresentationView;
import views.ViewVisitor;

public interface PresentationController extends ViewVisitor {
    void accept(PresentationView view);
}
