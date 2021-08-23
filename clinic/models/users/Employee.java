package clinic.models.users;

import clinic.models.Repository;

/**
 * Write a description of class Usuario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Employee extends Person {
    private Repository repository;

    protected Employee(PersonalData personalData, Repository repository) {
        super(personalData);
        this.repository = repository;
    }


    protected Repository getRepository() {
        return repository;
    }
}
