package clinic.controllers;

import clinic.models.States;
import clinic.models.users.PersonalData;
import clinic.views.View;
import clinic.views.ViewVisitor;

/**
 * Write a description of class StartController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * la clase se encarga de gestionar la logica de seleccion de actores
 * del sistema, pasando una lista de posibles actores a la vista
 */
public class StartController extends Controller implements ViewVisitor {

    private ManagementUserController managementUserController;


    /**
     * Construcor generico para instanciar la clase y guardar el objeto
     * Reception en el padre, crea los objetos necesarios por la instancia para
     * funcionar
     */
    public StartController() {
        this.managementUserController = new ManagementUserController();
    }

    /**
     * acepta un objeto de tipo view para lanzarle un mensaje a continuacion
     *
     * @param view una vista generica, a la que le pasamos
     *             la instancia como parametro, para que
     *             el receptor sepa de que tipo de objeto se trata.
     */
    @Override
    public void interact(View view) {
        view.visit(this);
    }

    /**
     * Realiza las operaciones necesarias para iniciar la aplicacion a un estado optimo
     *
     * @param personalData un visitador de controlador, usado por las vistas
     */
    public void start(PersonalData personalData) {
        assert (this.getState() == States.INITIAL);
        this.generateFixtures();
        this.getSession().setAdministrator(this.managementUserController.createAdmin(personalData));
        this.setState(States.STARTED);
    }

    /**
     * Inserta datos para poder usar el programa
     */
    private void generateFixtures() {
        new BuilderFixtures();
    }

    public AdminController getAdminCreatorController() {
        return new AdminController();
    }
}
