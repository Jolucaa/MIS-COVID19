package models;

/**
 * Write a description of class Seguridad here.
 * TODO: recibe una persona y una operacion y
 * determina si esa persona puede realizarla
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Security {
    // instance variables - replace the example below with your own
    private Permissions permisos;

    /**
     * Encargado de recorrer los posibles metodos registrados en
     * la colección Permisos y devolver el true/false en funcion de
     * si ha sido encontrado el metodo para el tipo de usuario pertinente
     */
    public boolean isPermissions(Person person, String operacion) {
        return true;
    }
}
