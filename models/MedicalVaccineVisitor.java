package models;

import models.errors.ClinicError;

/**
 * Write a description of interface MedicalVaccineVisitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface MedicalVaccineVisitor {

     ClinicError visit(Pfizer pfizer);

     ClinicError visit(Moderna moderna);

     ClinicError visit(Johnson johnson);

}
