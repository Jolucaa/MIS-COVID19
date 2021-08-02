package models;

import utils.IntegerLimited;

/**
 * Write a description of class PersonalInformation here.
 *
 * @author (Jose Luis Garcia Cabeza)
 * @version (alpha)
 */
public class PersonalInformation {
    private String name;
    private String surname;
    private Integer phone;

    /**
     * Constructor for objects of class PersonalInformation
     *
     * @param name    String
     * @param surname String
     * @param phone   Integer
     * @return PersonalInformation Object
     */
    public PersonalInformation(String name, String surname, Integer phone) {
        assert (name != null);
        assert (surname != null);
        assert (phone != null);
        assert (this.isValidPhone(phone));
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    /**
     * Comprueba si el campo phone tiene la longitud adecuada
     *
     * @return boolean  true si el campo esta en el intervalo
     */
    public boolean isValidPhone(Integer phone) {
        return new IntegerLimited(9, 9).set(phone) != null;
    }

    /**
     * Une el campo name y surname con un espacio en blanco
     * entre medias y  lo devuelve.
     *
     * @return String  El nombre compuesto de la persona
     */
    public String getNameFormat() {
        return this.getName() + " " + this.getSurname();
    }

    /**
     * Devuelve el campo name
     *
     * @return String  El nombre de la persona
     */
    protected String getName() {
        return this.name;
    }

    /**
     * Devuelve el campo surname
     *
     * @return String  El appellido de la persona
     */
    protected String getSurname() {
        return this.surname;
    }

    /**
     * Devuelve el campo phone
     *
     * @return Integer
     */
    public Integer getPhone() {
        return this.phone;
    }

    /**
     * actualiza el campo phone con el valor entregado
     *
     * @param phone Integer
     */
    public void setPhone(Integer phone) {
        assert (this.isValidPhone(phone));
        this.phone = phone;
    }

    /**
     * actualiza el campo name con el valor entregado
     *
     * @param name String
     */
    public void setName(String name) {
        assert (name != null);
        this.name = name;
    }

    /**
     * actualiza el campo surname con el valor entregado
     *
     * @param surname String
     */
    public void setSurname(String surname) {
        assert (surname != null);
        this.surname = surname;
    }
}
