package models;

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
    protected PersonalInformation getPersonalInformation(Technician technician) {
        return technician.getPersonalInformation();
    }

    @Override
    protected List<Technician> getList() {
        return this.technicians;
    }

    @Override
    protected Integer getId(Technician technician) {
        return technician.getCollegiateNumber();
    }

    @Override
    public Technician create(PersonalInformation personalInformation) {
        return new Technician(personalInformation);
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
