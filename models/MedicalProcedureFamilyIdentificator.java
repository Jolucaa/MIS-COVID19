package models;

public interface MedicalProcedureFamilyIdentificator extends MedicalProcedureVisitor{
    DiagnosticTest diagnosticFamily(PCR pcr);

    DiagnosticTest diagnosticFamily(SerologicalAnalysis serologicalAnalysis);

    DiagnosticTest diagnosticFamily(ClassicTest classicTest);

    DiagnosticTest diagnosticFamily(FastTest fastTest);

    Vaccine vaccineFamily(Pfizer pfizer);

    Vaccine vaccineFamily(Moderna moderna);

    Vaccine vaccineFamily(Johnson johnson);
}
