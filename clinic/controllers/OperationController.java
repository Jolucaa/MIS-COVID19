package clinic.controllers;

import clinic.views.View;
import clinic.views.ViewVisitor;

public class OperationController extends Controller implements ViewVisitor {
    @Override
    public void interact(View view) {
        view.visit(this);
    }
}
