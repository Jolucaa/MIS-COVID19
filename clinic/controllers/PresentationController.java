package clinic.controllers;

import clinic.views.View;
import clinic.views.ViewVisitor;

public interface PresentationController extends ViewVisitor {
    void accept(View view);
}
