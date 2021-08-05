package models.errors;

/**
 * Write a description of class ErrorNumeroLimitado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ErrorIntegerOutOfBounds extends ClinicError {
    /**
     * Constructor for objects of class ErrorNumeroLimitado
     */
    public ErrorIntegerOutOfBounds() {
        super("Error numero fuera de los limites: ");
    }
}
