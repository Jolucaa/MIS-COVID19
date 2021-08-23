package clinic.models;

import clinic.controllers.GenericManager;
import clinic.models.users.PersonalData;
import clinic.models.users.Technician;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class TechnicianManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TechnicianManager extends GenericManager<Technician> {
    // instance variables - replace the example below with your own
    private final ArrayList<Technician> technicians;

    /**
     * Constructor for objects of class TechnicianManager
     */
    public TechnicianManager() {
        // initialise instance variables
        this.technicians = new ArrayList<>();
    }

    @Override
    protected PersonalData getPersonalInformation(Technician technician) {
        return technician.getPersonalInformation();
    }

    @Override
    public List<Technician> getList() {
        return this.technicians;
    }

    @Override
    protected Integer getId(Technician technician) {
        return technician.getCollegiateNumber();
    }

    @Override
    public Technician create(PersonalData personalData) {
        return new Technician(personalData);
    }

    @Override
    public void edit(Technician person) {
        //TODO edicion de technician
    }

    public List<Technician> getTechniciansAvailable() {
        ArrayList<Technician> technicianAvailable = new ArrayList<>();
        for (Technician technician : this.getList()) {
            if (technician.isAvailable()) {
                technicianAvailable.add(technician);
            }
        }
        return technicianAvailable;
    }
}
