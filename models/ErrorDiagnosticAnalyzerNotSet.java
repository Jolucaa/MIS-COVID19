package models;

public class ErrorDiagnosticAnalyzerNotSet extends ClinicError {
    public ErrorDiagnosticAnalyzerNotSet() {
        super("No hay tecnico asociado a esta prueba");
    }
}
