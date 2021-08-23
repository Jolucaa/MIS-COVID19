package clinic.models.errors;

public class ErrorFieldCantBeBlank extends ClinicError{
    public ErrorFieldCantBeBlank() {
        super("No se permite el campo en blanco");
    }
}
