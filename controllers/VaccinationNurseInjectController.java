package controllers;

import models.*;
import models.errors.ClinicError;

import java.util.List;

public class VaccinationNurseInjectController implements MedicalVaccineVisitor {

    private Reception reception;

    public VaccinationNurseInjectController(Reception reception) {
        this.reception = reception;
    }

    public List<Vaccine> getVaccineCanInject(Patient patient) {
        return reception.getVaccineCanInject(patient);
    }

    public void accept(Vaccine vaccine) {
        vaccine.accept(this);
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
}
