package models.errors;

import models.errors.ClinicError;

/**
 * Write a description of class ErrorGurdado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaveError extends ClinicError {
    /**
     * Constructor for objects of class ErrorGurdado
     */
    public SaveError() {
        super("Error al guardar: ");
    }

}
