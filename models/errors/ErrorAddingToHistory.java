package models.errors;

public class ErrorAddingToHistory extends ClinicError {
    public ErrorAddingToHistory() {
        super("No se ha podido agregar el elemento al historial");
    }
}
