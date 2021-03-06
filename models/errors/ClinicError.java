package models.errors;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase con la finalidad de trabajar polimorficamente con ella
 * especificando los errores posibles de la aplicación
 * en las subclases. Los errores manejados de esta jerarquia son los
 * respectivos a la validación de datos y/o a los permisos del áctor.
 *
 * @author: Date:
 */
public class ClinicError {
    // instance variables - replace the example below with your own
    private ArrayList<ClinicError> errors = new ArrayList<>();
    private String errorMessage;

    public ClinicError() {
        this.errorMessage = "";
    }

    protected ClinicError(String errorMessage) {
        assert errorMessage != null;
        this.errorMessage = errorMessage;
        this.register();
    }

    protected void register() {
        this.add(this);
    }

    public void add(ClinicError error) {
        if (error != null) {
            this.errors.add(error);
        }
    }

    protected List<ClinicError> getStackErrors() {
        return this.errors;
    }

    protected ClinicError getError() {
        return this.getStackErrors().get(this.getStackErrors().size() - 1);
    }

    protected String getErrorMessage() {
        return this.errorMessage;
    }

    public String buildErrorTrace() {
        StringBuilder errorTrace = new StringBuilder();
        while (!this.isStackEmpty()) {
            errorTrace.append(this.getError().getErrorMessage()).append("/n");
            this.remove();
            this.buildErrorTrace();
        }
        return errorTrace.toString();
    }

    public void remove() {
        this.getStackErrors().remove(this.getError());
    }

    public boolean isStackEmpty(){
        return this.getStackErrors().isEmpty();
    }
}
