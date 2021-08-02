package models;

import java.util.ArrayList;

/**
 * Clase con la finalidad de trabajar polimorficamente con ella
 * especificando los errores posibles de la aplicación
 * en las subclases. Los errores manejados de esta jerarquia son los
 * respectivos a la validación de datos y/o a los permisos del áctor.
 *
 * @author: Date:
 */
public abstract class ClinicError {
    // instance variables - replace the example below with your own
    private ArrayList<ClinicError> errors = new ArrayList<>();
    private String errorMessage;

    protected ClinicError(String errorMessage) {
        assert errorMessage != null;
        this.errorMessage = errorMessage;
        this.register();
    }

    protected void register() {
        this.add(this);
    }

    protected void add(ClinicError error) {
        assert error != null;
        this.errors.add(error);
    }

    protected ArrayList<ClinicError> getStackErrors() {
        return this.errors;
    }

    public ClinicError getError() {
        return this.getStackErrors().get(this.getStackErrors().size());
    }

    private ClinicError getError(Integer position) {
        assert position != null;
        assert position >= 0;
        return this.getStackErrors().get(position);
    }

    protected String getErrorMessage() {
        return this.errorMessage;
    }

    public String buildErrorTrace() {
        String errorTrace = "";
        while (!this.getStackErrors().isEmpty()) {
            errorTrace += this.getError().getErrorMessage();
            this.remove();
            this.buildErrorTrace();
        }
        return errorTrace;
    }

    public void remove() {
        this.getStackErrors().remove(this.getError());
    }
}
