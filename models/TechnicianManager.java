package models;

import java.util.ArrayList;

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
    protected ArrayList<Technician> getArrayList() {
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

    public ArrayList<Technician> getTechniciansAvailables(){
        ArrayList<Technician> technicianAvailable = new ArrayList<>();
        for(Technician technician:this.getArrayList()){
            if(technician.isNurseAvailable()){
                technicianAvailable.add(technician);
            }
        }
        return technicianAvailable;
    }
}
