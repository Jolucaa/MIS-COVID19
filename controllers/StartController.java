package controllers;

import models.PersonalInformation;
import models.Reception;
import models.States;
import views.MainView;

/**
 * Write a description of class StartController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * la clase se encarga de gestionar la logica de seleccion de actores
 * del sistema, pasando una lista de posibles actores a la vista
 */
public class StartController extends Controller {

    private ManagementUserController managementUserController;


    /**
     * Construcor generico para instanciar la clase y guardar el objeto
     * Reception en el padre, crea los objetos necesarios por la instancia para
     * funcionar
     */
    public StartController(Reception reception) {
        super(reception);
        this.managementUserController = new ManagementUserController(reception);
    }

    /**
     * acepta un objeto de tipo view para lanzarle un mensaje a continuacion
     *
     * @param mainView una vista generica, a la que le pasamos
     *             la instancia como parametro, para que
     *             el receptor sepa de que tipo de objeto se trata.
     */
    @Override
    public void interact(MainView mainView) {
        mainView.visit(this);
    }

    /**
     * Realiza las operaciones necesarias para iniciar la aplicacion a un estado optimo
     *
     * @param personalInformation un visitador de controlador, usado por las vistas
     */
    public void start(PersonalInformation personalInformation) {
        assert (this.getState() == States.INITIAL);
        this.generateFixtures();
        this.getReception().setAdministrator(this.managementUserController.createAdmin(personalInformation));
        this.setState(States.STARTED);
    }

    /**
     * Inserta datos para poder usar el programa
     */
    private void generateFixtures() {
    }

    public AdminCreatorController getAdminCreatorController() {
        return new AdminCreatorController(this.getReception());
    }
}
