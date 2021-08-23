package clinic.models.medical;

import clinic.models.medical.diagnostics.*;
import clinic.models.medical.vaccines.Johnson;
import clinic.models.medical.vaccines.Moderna;
import clinic.models.medical.vaccines.Pfizer;
import clinic.models.medical.vaccines.Vaccine;

public interface MedicalProcedureFamilyIdentificator extends MedicalProcedureVisitor {
    DiagnosticTest diagnosticFamily(PCR pcr);

    DiagnosticTest diagnosticFamily(SerologicalAnalysis serologicalAnalysis);

    DiagnosticTest diagnosticFamily(ClassicTest classicTest);

    DiagnosticTest diagnosticFamily(FastTest fastTest);

    Vaccine vaccineFamily(Pfizer pfizer);

    Vaccine vaccineFamily(Moderna moderna);

    Vaccine vaccineFamily(Johnson johnson);
}
