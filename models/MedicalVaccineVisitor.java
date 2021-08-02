package models;

/**
 * Write a description of interface MedicalVaccineVisitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface MedicalVaccineVisitor {

     void visit(Pfizer pfizer);

     void visit(Moderna moderna);

     void visit(Johnson johnson);

}
