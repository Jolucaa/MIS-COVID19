package clinic.models.users;

import java.util.Random;

/**
 * Write a description of class PersonalData here.
 *
 * @author (Jose Luis Garcia Cabeza)
 * @version (alpha)
 */
public class PersonalData {
    private String name;
    private String surname;
    private Integer phone;
    private Integer age;
    private final Random randomGenerator = new Random();

    /**
     * Constructor for objects of class PersonalData
     * that is build with empty parameters
     */
    public PersonalData() {
        this.setPhone(this.generateRandomPhone());
        this.setAge(this.generateRandomAge());
    }

    public PersonalData(String name, String surname) {
        this();
        this.setName(name);
        this.setSurname(surname);
    }

    public PersonalData(String name, String surname, Integer phone) {
        this(name, surname);
        this.setPhone(phone);
    }

    /**
     * Constructor for objects of class PersonalData
     *
     * @param name    String
     * @param surname String
     * @param phone   Integer
     * @param age     Integer
     */
    public PersonalData(String name, String surname, Integer phone, Integer age) {
        this(name, surname, phone);
        this.setAge(age);
    }

    private Integer generateRandomPhone(){
        return this.getRandomGenerator().nextInt(9);
    }

    private Integer generateRandomAge(){
        return this.getRandomGenerator().nextInt(3);
    }

    /**
     * Devuelve devuelve un obejeto de tipo  random
     * @return Random  - obejto random de la libreria java.util
     */
    private Random getRandomGenerator() {
        return randomGenerator;
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
    public PersonalData setPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    /**
     * actualiza el campo name con el valor entregado
     *
     * @param name String
     */
    public PersonalData setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * actualiza el campo surname con el valor entregado
     *
     * @param surname String
     */
    public PersonalData setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public PersonalData setAge(Integer age) {
        this.age = age;
        return this;
    }
}
