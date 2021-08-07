package views;

import controllers.CreateVaccinationController;
import controllers.DiagnosticTestController;

public interface MedicalProceduresView {

    void visit(CreateVaccinationController createVaccinationController);

    void visit(DiagnosticTestController diagnosticTestController);
}
