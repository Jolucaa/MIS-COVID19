package models;

public class ErroDiagnostictAnalyzerNotSet extends ClinicError {
    public ErroDiagnostictAnalyzerNotSet() {
        super("No hay tecnico asociado a esta prueba");
    }
}
