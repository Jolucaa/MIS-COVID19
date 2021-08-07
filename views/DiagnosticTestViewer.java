package views;


import controllers.DiagnosticTestController;

public class DiagnosticTestViewer extends ClinicView {

    public void interact(DiagnosticTestController diagnosticTestController) {
        this.write();
    }

    @Override
    protected void write() {
        this.writeConsole("Menu de pruebas diagnosticas");
    }

}
