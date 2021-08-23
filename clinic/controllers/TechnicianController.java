package clinic.controllers;


import clinic.models.TechnicianManager;
import clinic.models.users.PersonalData;
import clinic.models.users.Technician;

/**
 * Write a description of class newTechnicianController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TechnicianController extends Controller {
    private TechnicianManager technicianManager;

    /**
     * m
     * Construcor generico para instanciar la clase y guardar el objeto
     * Reception en el padre
     */
    public TechnicianController() {
        this.technicianManager = new TechnicianManager();
    }

    /**
     * Crea un técnico de laboratorio
     *
     * @param personalData - Objeto que encapsula la información general de una persona
     */
    public void create(PersonalData personalData) {
        this.getTechnicianManager().create(personalData);
    }

    private TechnicianManager getTechnicianManager() {
        return technicianManager;
    }

    private void register(Technician technician) {
        this.getTechnicianManager().register(technician);
    }

}
