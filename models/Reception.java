package models;

import java.util.List;

public class Reception {

    private Administrator administrator;
    private States states ;
    private Session session;

    public Reception() {
        this.states = States.INITIAL;
        this.session = new Session();
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public void setUser(User user){
        this.getSession().setUser(user);
    }

    public User getUser(){
       return this.getSession().getUser();
    }

    public Session getSession() {
        return session;
    }


    public void setAdministrator(Administrator administrator){
        this.administrator = administrator;
    }

    public void registerPatient(PersonalInformation personalInformation,Integer SIP) {
        this.getAdministrator().register(this.getAdministrator().createPatient(personalInformation,SIP));
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

    public List<Nurse> getNursesAvailable() {
        return this.getAdministrator().getNurseManager().getNursesAvailable();
    }

    public List<Technician> getTechnicianAvailables() {
        return this.getAdministrator().getTechnicianManager().getTechniciansAvailable();
    }

    public States getState() {
        return this.states;
    }

    public void setState(States state) {
        this.states = state;
    }

    public List<Technician> getTechnicianList(){
        return this.getAdministrator().getTechnicianManager().getList();
    }

    public List<Patient> getPatientList(){
        return this.getAdministrator().getPatientManager().getList();
    }

    public List<Nurse> getNurseList(){
        return this.getAdministrator().getNurseManager().getList();
    }

    public List<MedicalProcedure> getMedicalProcessForPatient(Patient patient){
       return patient.getMedicalProcessForPatient();
    }

    public List<Vaccine> getVaccineCanInject(Patient patient){
        return patient.getVaccineCanInject();
    }

    public List<DiagnosticTest> getDiagnosticsCanDo(Patient patient){
        return patient.getDiagnosticsCanDo();
    }
}
