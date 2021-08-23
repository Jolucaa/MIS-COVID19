package clinic;

import clinic.views.ConsoleView;
import clinic.views.View;
import clinic.views.ViewVisitor;

/**
 * Write a description of class clinica here.
 *
 * @author (Jose Luis Garcia Cabeza)
 * @version (alpha - 0.0.0)
 */
public class Clinica {
    private final Logic logic;
    private final View view;

    /**
     * Init point of program
     */
    public static void main(String[] args) {
        new Clinica(new ConsoleView(), new Logic()).start();
    }

    public Clinica(View view, Logic logic) {
        this.view = view;
        this.logic = logic;
    }

    /*
     * Inicia los controladores que gestionaran
     * la logica de la clinica
     */
    private void start() {
        ViewVisitor controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                view.interact(controller);
            }
        } while (controller != null);

    }

}
