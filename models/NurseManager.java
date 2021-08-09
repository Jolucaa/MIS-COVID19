package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class NurseManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NurseManager extends GenericManager<Nurse> {
    // instance variables - replace the example below with your own
    private final ArrayList<Nurse> nurses;

    /**
     * Constructor for objects of class NurseManager
     */
    public NurseManager() {
        this.nurses = new ArrayList<>();
    }

    @Override
    protected PersonalInformation getPersonalInformation(Nurse nurse) {
        return nurse.getPersonalInformation();
    }

    protected ArrayList<Nurse> getList() {
        return this.nurses;
    }

    @Override
    protected Integer getId(Nurse nurse) {
        return nurse.getCollegiateNumber();
    }

    public Nurse create(PersonalInformation personalInformation) {
        return new Nurse(personalInformation);
    }

    public List<Nurse> getNursesAvailable() {
        ArrayList<Nurse> nursesAvailable = new ArrayList<>();
        for (Nurse nurse : this.getList()) {
            if (nurse.isAvailable()) {
                nursesAvailable.add(nurse);
            }
        }
        return nursesAvailable;
    }

}
