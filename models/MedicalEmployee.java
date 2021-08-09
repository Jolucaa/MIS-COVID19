package models;

/**
 * Abstract class Empleado - write a description of the class here
 *
 * @author: Date:
 */
public abstract class MedicalEmployee extends Employee {
    private static Integer instanceNumber = 0;
    private final Integer collegiateNumber;

    protected MedicalEmployee(PersonalInformation personalInformation) {
        super(personalInformation);
        this.collegiateNumber = instanceNumber++;
    }

    public Integer getCollegiateNumber() {
        return this.collegiateNumber;
    }

    public void add(Patient patient) {
        this.getPatientManager().add(patient);
    }
}
