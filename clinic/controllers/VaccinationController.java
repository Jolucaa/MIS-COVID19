package clinic.controllers;

import clinic.models.errors.ClinicError;
import clinic.models.medical.vaccines.*;
import clinic.models.users.Nurse;
import clinic.models.users.Patient;

import java.util.List;


public class VaccinationController extends Controller implements MedicalVaccineVisitor {

    public void createPfizer(Patient patient, Nurse nurse) {
        patient.addToMedicalHistory(new Pfizer(patient, nurse));
    }

    public void createModerna(Patient patient, Nurse nurse) {
        patient.addToMedicalHistory(new Moderna(patient, nurse));
    }

    public void createJohnson(Patient patient, Nurse nurse) {
        patient.addToMedicalHistory(new Johnson(patient, nurse));
    }

    public List<Vaccine> showVaccinesAvailable(Patient patient) {
        return this.getVaccineCanInject(patient);
    }

    public List<Vaccine> getVaccineCanInject(Patient patient) {
        return patient.getMedicalStatistics().getVaccineCanInject();
    }

    @Override
    public ClinicError visit(Pfizer pfizer) {

        return null;
    }

    @Override
    public ClinicError visit(Moderna moderna) {

        return null;
    }

    @Override
    public ClinicError visit(Johnson johnson) {

        return null;
    }

    public void accept(Vaccine procedure) {
        procedure.accept(this);
    }
}
