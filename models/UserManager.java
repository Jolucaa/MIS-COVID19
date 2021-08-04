package models;

/**
 * Write a description of class UserManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class UserManager extends Employee {
    // instance variables - replace the example below with your own
    private final NurseManager nurseManager;
    private final TechnicianManager technicianManager;

    /**
     * Constructor for objects of class UserManager
     */
    protected UserManager(PersonalInformation personalInformation) {
        super(personalInformation);
        this.nurseManager = new NurseManager();
        this.technicianManager = new TechnicianManager();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param nurse un objeto de la clase Nurse
     */
    public void register(Nurse nurse) {
        this.getNurseManager().register(nurse);
    }

    protected NurseManager getNurseManager() {
        return nurseManager;
    }

    public void register(Technician technician) {
        this.getTechnicianManager().register(technician);
    }

    protected TechnicianManager getTechnicianManager() {
        return technicianManager;
    }

    public Technician createTechnician(PersonalInformation personalInformation) {
        return this.getTechnicianManager().create(personalInformation);
    }

    public Nurse createNurse(PersonalInformation personalInformation) {
        return this.getNurseManager().create(personalInformation);
    }

    public void register(Patient patient) {
        this.getPatientManager().register(patient);
    }

    public Patient createPatient(PersonalInformation personalInformation, Integer age, Integer SIP) {
        return this.getPatientManager().create(personalInformation, age, SIP);
    }

    public void add(Technician technician) {
        this.getTechnicianManager().add(technician);
    }

    public void add(Nurse nurse) {
        this.getNurseManager().add(nurse);
    }

    public void add(Patient patient) {
        this.getPatientManager().add(patient);
    }


}
