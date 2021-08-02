package controllers;

import models.*;

import java.util.ArrayList;

public class VaccinationNurseInjectController implements MedicalProcedureVisitor {

    private Reception reception;
    public VaccinationNurseInjectController(Reception reception) {
        this.reception = reception;
    }

    public ArrayList<MedicalProcedure> getMedicalProcessForPatient(Patient patient){
        return reception.getMedicalProcessForPatient(patient);
    }

    @Override
    public boolean visit(Pfizer pfizer) {
        return false;
    }

    @Override
    public boolean visit(Moderna moderna) {
        return false;
    }

    @Override
    public boolean visit(Johnson johnson) {
        return false;
    }

    @Override
    public boolean visit(PCR pcr) {
        return false;
    }

    @Override
    public boolean visit(SerologicalAnalysis serologicalAnalysis) {
        return false;
    }

    @Override
    public boolean visit(ClassicTest classicTest) {
        return false;
    }

    @Override
    public boolean visit(FastTest fastTest) {
        return false;
    }

    @Override
    public DiagnosticTest identify(PCR pcr) {
        return null;
    }

    @Override
    public DiagnosticTest identify(SerologicalAnalysis serologicalAnalysis) {
        return null;
    }

    @Override
    public DiagnosticTest identify(ClassicTest classicTest) {
        return null;
    }

    @Override
    public DiagnosticTest identify(FastTest fastTest) {
        return null;
    }

    @Override
    public Vaccine vaccineFamily(Pfizer pfizer) {
        return null;
    }

    @Override
    public Vaccine vaccineFamily(Moderna moderna) {
        return null;
    }

    @Override
    public Vaccine vaccineFamily(Johnson johnson) {
        return null;
    }

    public void accept(MedicalProcedure procedure) {
        procedure.accept(this);
    }
}
