package models;

public interface MedicalProcedureVisitor{
    boolean visit(Pfizer pfizer);

    boolean visit(Moderna moderna);

    boolean visit(Johnson johnson);

    boolean visit(PCR pcr);

    boolean visit(SerologicalAnalysis serologicalAnalysis);

    boolean visit(ClassicTest classicTest);

    boolean visit(FastTest fastTest);

    DiagnosticTest identify(PCR pcr);

    DiagnosticTest identify(SerologicalAnalysis serologicalAnalysis);

    DiagnosticTest identify(ClassicTest classicTest);

    DiagnosticTest identify(FastTest fastTest);

    Vaccine vaccineFamily(Pfizer pfizer);

    Vaccine vaccineFamily(Moderna moderna);

    Vaccine vaccineFamily(Johnson johnson);
}
