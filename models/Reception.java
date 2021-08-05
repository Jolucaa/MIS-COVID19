package models;

import java.util.List;

public class Reception {

    private Administrator administrator;
    private States states ;

    public Reception() {
        this.states = States.INITIAL;
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

    public List<Nurse> getNursesAvailables() {
        return this.getAdministrator().getNurseManager().getNursesAvailable();
    }

    public List<Technician> getTechnicianAvailables() {
        return this.getAdministrator().getTechnicianManager().getTechniciansAvailables();
    }

    public States getState() {
        return this.states;
    }

    public void setState(States state) {
        this.states = state;
    }

    public List<Technician> getTechnicianList(){
        return this.getAdministrator().getTechnicianManager().getArrayList();
    }

    public List<Patient> getPatientList(){
        return this.getAdministrator().getPatientManager().getArrayList();
    }

    public List<Nurse> getNurseList(){
        return this.getAdministrator().getNurseManager().getArrayList();
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
