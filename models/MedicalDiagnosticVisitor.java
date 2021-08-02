package models;

/**
 * Write a description of interface VisitadorProcedimiento here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface MedicalDiagnosticVisitor {
     void visit(PCR pcr);

     void visit(SerologicalAnalysis serologicalAnalysis);

     void visit(ClassicTest classicTest);

     void visit(FastTest fastTest);

}
