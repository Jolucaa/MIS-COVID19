package models;

/**
 * Abstract class Persona - write a description of the class here
 *
 * @author: Date:
 */
public abstract class Person implements User{
    // instance variables - replace the example below with your own
    private PersonalInformation information;

    protected Person(PersonalInformation information) {
        this.information = information;
    }

    protected PersonalInformation getPersonalInformation() {
        return this.information;
    }

    /**
     * Une el campo name y surname con un espacio en blanco
     * entre medias y  lo devuelve.
     *
     * @return String  El nombre compuesto de la persona
     */
    public String getNameFormat() {
        return this.getPersonalInformation().getNameFormat();
    }

    /**
     * Devuelve el campo name
     *
     * @return String  El nombre de la persona
     */
    public String getName() {
        return this.getPersonalInformation().getName();
    }

    /**
     * Devuelve el campo surname
     *
     * @return String  El appellido de la persona
     */
    public String getSurname() {
        return this.getPersonalInformation().getSurname();
    }

    /**
     * Devuelve el campo phone
     *
     * @return Integer
     */
    public Integer getPhone() {
        return this.getPersonalInformation().getPhone();
    }

    /**
     * actualiza el campo phone con el valor entregado
     *
     * @param phone Integer
     */
    public void setPhone(Integer phone) {
        this.getPersonalInformation().setPhone(phone);
    }

    /**
     * actualiza el campo name con el valor entregado
     *
     * @param name String
     */
    public void setName(String name) {
        this.getPersonalInformation().setName(name);
    }

    /**
     * actualiza el campo surname con el valor entregado
     *
     * @param surname String
     */
    public void setSurname(String surname) {
        this.getPersonalInformation().setSurname(surname);
    }

    public abstract Integer getId();

    public Integer getAge(){
        return this.getPersonalInformation().getAge();
    }
}
