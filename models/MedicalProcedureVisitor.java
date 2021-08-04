package models;

public interface MedicalProcedureVisitor{
    void visit(Pfizer pfizer);

    void visit(Moderna moderna);

    void visit(Johnson johnson);

    void visit(PCR pcr);

    void visit(SerologicalAnalysis serologicalAnalysis);

    void visit(ClassicTest classicTest);

    void visit(FastTest fastTest);
}
