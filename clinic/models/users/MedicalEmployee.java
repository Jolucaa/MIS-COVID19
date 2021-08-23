package clinic.models.users;

import clinic.models.Repository;

/**
 * Abstract class Empleado - write a description of the class here
 *
 * @author: Date:
 */
public abstract class MedicalEmployee extends Employee {
    private static Integer instanceNumber = 0;
    private final Integer collegiateNumber;

    protected MedicalEmployee(PersonalData personalData, Repository repository) {
        super(personalData, repository);
        this.collegiateNumber = instanceNumber++;
    }

    public Integer getCollegiateNumber() {
        return this.collegiateNumber;
    }

}
