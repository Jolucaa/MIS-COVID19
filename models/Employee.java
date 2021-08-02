package models;

/**
 * Write a description of class Usuario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Employee extends Person implements MedicalDiagnosticVisitor {
    private final PatientManager patientManager;

    protected Employee(PersonalInformation personalInformation) {
        super(personalInformation);
        this.patientManager = new PatientManager();
    }

    protected PatientManager getPatientManager() {
        return this.patientManager;
    }
}
