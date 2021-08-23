package clinic.models.users;

import clinic.models.RepositoryImplementation;

import java.util.List;

/**
 * Write a description of class Administrator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Administrator extends Employee implements User {
    private static Integer numInstance = 0;
    private final Integer identifier;

    /**
     * Constructor for objects of class Administrator
     */
    public Administrator(PersonalData personalData) {
        super(personalData, new RepositoryImplementation());
        this.identifier = Administrator.numInstance++;
    }

    @Override
    public Integer getId() {
        return this.identifier;
    }

    public List<Patient> getPatientList() {
        return this.getRepository().getPatientList();
    }
}
