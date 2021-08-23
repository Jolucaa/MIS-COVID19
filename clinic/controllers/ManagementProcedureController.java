package clinic.controllers;

import clinic.models.errors.ClinicError;
import clinic.models.errors.ErrorPatientWithoutProcedures;
import clinic.models.medical.MedicalProcedure;
import clinic.models.users.Patient;

import java.util.List;

/**
 * Write a description of class ManagementProcedureController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ManagementProcedureController extends Controller {
    private VaccinationController vaccinationController;
    private DiagnosticTestController diagnosticTestController;
    private PatientController patientController;
//TODO revisar

    /**
     * Constructor for objects of class ManagementProcedureController
     */
    public ManagementProcedureController() {
        this.vaccinationController = new VaccinationController();
        this.diagnosticTestController = new DiagnosticTestController();
        this.patientController = new PatientController();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *
     */
    public ClinicError control() {
        ClinicError error = new ClinicError();
        Patient patient = this.patientController.getPatient(0);
        List<MedicalProcedure> medicalProcedures = this.patientController.getMedicalProcessForPatient(patient);
        if (medicalProcedures.isEmpty()) {
            error.add(new ErrorPatientWithoutProcedures());
        }
        return error;
    }
}
