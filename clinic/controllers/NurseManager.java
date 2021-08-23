package clinic.controllers;

import clinic.models.users.Nurse;
import clinic.models.users.PersonalData;

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
    protected PersonalData getPersonalInformation(Nurse nurse) {
        return nurse.getPersonalInformation();
    }

    public ArrayList<Nurse> getList() {
        return this.nurses;
    }

    @Override
    protected Integer getId(Nurse nurse) {
        return nurse.getCollegiateNumber();
    }

    public Nurse create(PersonalData personalData) {
        return new Nurse(personalData);
    }

    @Override
    public void edit(Nurse person) {

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
