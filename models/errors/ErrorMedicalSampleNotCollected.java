package models.errors;

public class ErrorMedicalSampleNotCollected extends ClinicError{
    protected ErrorMedicalSampleNotCollected() {
        super("No se ha recogido la muestra");
    }
}
