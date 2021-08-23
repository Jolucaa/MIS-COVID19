package clinic.models.errors;

public class ErrorPatientWithoutProcedures extends ClinicError {
    public ErrorPatientWithoutProcedures(){
        super("No hay procedimientos para este paciente");
    }
}
