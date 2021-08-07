package views;

import controllers.DiagnosticTestController;
import controllers.VaccinationController;

public interface MedicalProceduresView {

    void visit(VaccinationController vaccinationController);

    void visit(DiagnosticTestController diagnosticTestController);
}
