package controllers;
import models.ClinicError;
import views.PresentationView;
import models.Reception;

/**
 * Write a description of class AtrasControlador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BackController extends Controller implements PresentatorVisitor {
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class AtrasControlador
     */
    public BackController(Reception reception) {
        super(reception);
    }

    @Override
    public ClinicError control() {
        return null;
    }


    /**
     * An example of a method - replace this comment with your own
     *
     * @param view a sample parameter for a method
     */
    public void visit(PresentationView view) {
        view.visit(this);;
    }

    @Override
    public void accept(PresentationView controller) {

    }
}
