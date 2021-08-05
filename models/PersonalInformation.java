package models;

import models.errors.ClinicError;
import models.errors.ErrorFieldCantBeBlank;
import models.errors.ErrorIntegerOutOfBounds;
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
    private IntegerLimited integerLimited;

    /**
     * Constructor for objects of class PersonalInformation
     *  that is build with empty parameters
     *
     */
    public PersonalInformation() {
        this.integerLimited = new IntegerLimited(9, 9);
    }

    /**
     * Constructor for objects of class PersonalInformation
     *
     * @param name    String
     * @param surname String
     * @param phone   Integer
     */
    public PersonalInformation(String name, String surname, Integer phone) {
        this.setName(name);
        this.setSurname(surname);
        this.setPhone(phone);
        this.integerLimited = new IntegerLimited(9, 9);
    }

    /**
     * Comprueba si el campo phone tiene la longitud adecuada
     *
     * @return boolean  true si el campo esta en el intervalo
     */
    public boolean isValidPhone(Integer phone) {
        return this.getIntegerLimited().set(phone) != null;
    }

    public IntegerLimited getIntegerLimited() {
        return integerLimited;
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
    public ClinicError setPhone(Integer phone) {
        if(this.isValidPhone(phone)){
            this.phone = phone;
            return null;
        }
        return new ErrorIntegerOutOfBounds();
    }

    /**
     * actualiza el campo name con el valor entregado
     *
     * @param name String
     */
    public ClinicError setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return null;
        }
        return new ErrorFieldCantBeBlank();
    }

    /**
     * actualiza el campo surname con el valor entregado
     *
     * @param surname String
     */
    public ClinicError setSurname(String surname) {
        if(surname != null && !surname.isEmpty()) {
            this.surname = surname;
            return null;
        }
        return new ErrorFieldCantBeBlank();
    }
}
