package clinic.models.medical;

import clinic.models.medical.diagnostics.MedicalDiagnosticVisitor;
import clinic.models.medical.vaccines.MedicalVaccineVisitor;

public interface MedicalProcedureVisitor extends MedicalVaccineVisitor, MedicalDiagnosticVisitor {
}
