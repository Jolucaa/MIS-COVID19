package controllers;
import models.ClinicError;
import views.ControllerViewVisitor;
import models.PersonalInformation;
import models.Reception;
import models.States;
import views.ViewVisitor;

/**
 * Write a description of class StartController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * la clase se encarga de gestionar la logica de seleccion de actores
 * del sistema, pasando una lista de posibles actores a la vista
 */
public class StartController extends Controller implements ViewVisitor {

    private UserManagementController userManagementController;
    private BackController backController;

    /**
     * Construcor generico para instanciar la clase y guardar el objeto
     * Reception en el padre, crea los objetos necesarios por la instancia para
     * funcionar
     */
    public StartController(Reception reception) {
        super(reception);
        this.userManagementController = new UserManagementController(reception);
        this.backController = new BackController(reception);

    }

    @Override
    public ClinicError control() {
        return null;
    }


    /**
     * acepta un objeto de tipo view para lanzarle un mensaje a continuacion
     *
     * @param controllerViewVisitor una vista generica, a la que le pasamos
     *             la instancia como parametro, para que
     *             el receptor sepa de que tipo de objeto se trata.
     */
    @Override
    public void interact(ControllerViewVisitor controllerViewVisitor) {
        controllerViewVisitor.visit(this);
    }

    /**
     * Realiza las operaciones necesarias para iniciar la aplicacion a un estado optimo
     *
     * @param personalInformation un visitador de controlador, usado por las vistas
     */
    public void start(PersonalInformation personalInformation) {
        assert (this.getState() == States.INITIAL);
        this.generateFixtures();
        this.getReception().setAdministrator(this.userManagementController.createAdmin(personalInformation));
        this.setState(States.STARTED);
    }

    /**
     * Inserta datos para poder usar el programa
     *
     */
    private void generateFixtures() {
    }

}
