package models;

import java.util.ArrayList;

public class Reception {

    private Administrator administrator;
    private States states ;
    private Security security;

    public Reception() {
        this.states = States.INITIAL;
        this.security = new Security();
    }

    public boolean isUserGrantied(Person user,String cllassName){
        return this.security.isPermissions(user, cllassName);
    }

    public void setAdministrator(Administrator administrator){
        this.administrator = administrator;
    }

    public void registerPatient(PersonalInformation personalInformation,Integer age, Integer SIP) {
        this.getAdministrator().register(this.getAdministrator().createPatient(personalInformation,age,SIP));
    }

    public void registerTechnician(PersonalInformation personalInformation) {
        this.getAdministrator().register(this.getAdministrator().createTechnician(personalInformation));
    }

    public void registerNurse(PersonalInformation personalInformation) {
        this.getAdministrator().register(this.getAdministrator().createNurse(personalInformation));
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public ArrayList<Nurse> getNursesAvailables() {
        return this.getAdministrator().getNurseManager().getNursesAvailables();
    }

    public ArrayList<Technician> getTechnicianAvailables() {
        return this.getAdministrator().getTechnicianManager().getTechniciansAvailables();
    }

    public States getState() {
        return this.states;
    }

    public void setState(States state) {
        this.states = state;
    }

    public ArrayList<Technician> getTechnicianList(){
        return this.getAdministrator().getTechnicianManager().getArrayList();
    }

    public ArrayList<Patient> getPatientList(){
        return this.getAdministrator().getPatientManager().getArrayList();
    }

    public ArrayList<Nurse> getNurseList(){
        return this.getAdministrator().getNurseManager().getArrayList();
    }

    public ArrayList<MedicalProcedure> getMedicalProcessForPatient(Patient patient){
       return patient.getMedicalProcessForPatient();
    }
}
