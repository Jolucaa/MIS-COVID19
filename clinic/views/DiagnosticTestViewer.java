package clinic.views;


public class DiagnosticTestViewer extends ClinicView {

    public void interact() {
        this.write();
    }

    @Override
    public void write() {
        this.writeConsole("MainMenu de pruebas diagnosticas");
    }

}
