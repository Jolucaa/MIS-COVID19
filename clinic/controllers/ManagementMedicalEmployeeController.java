package clinic.controllers;

public class ManagementMedicalEmployeeController extends Controller {
    private NurseController nurseController;
    private TechnicianController technicianController;

    public ManagementMedicalEmployeeController() {
        this.nurseController = new NurseController();
        this.technicianController = new TechnicianController();
    }

    public TechnicianController getTechnicianController() {
        return this.technicianController;
    }

    public NurseController getNurseController() {
        return this.nurseController;
    }


}
