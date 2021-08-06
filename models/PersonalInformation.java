package models;

import models.errors.ClinicError;
import models.errors.ErrorFieldCantBeBlank;
import models.errors.ErrorIntegerOutOfBounds;
import utils.IntegerLimited;

import java.util.Random;

/**
 * Write a description of class PersonalInformation here.
 *
 * @author (Jose Luis Garcia Cabeza)
 * @version (alpha)
 */
public class PersonalInformation {
    private static final Integer PHONE_LONGITUDE = 9;
    private static final Integer AGE_MAXIM_LONGITUDE = 3;
    private String name;
    private String surname;
    private Integer phone;
    private Integer age;
    private final Random randomGenerator = new Random();

    /**
     * Constructor for objects of class PersonalInformation
     *  that is build with empty parameters
     *
     */
    public PersonalInformation() {
        this.setPhone(this.generateRandomPhone());
        this.setAge(this.generateRandomAge());
    }

    public PersonalInformation(String name, String surname) {
        this();
        this.setName(name);
        this.setSurname(surname);
    }

    public PersonalInformation(String name, String surname, Integer phone) {
        this(name,surname);
        this.setPhone(phone);
    }

    /**
     * Constructor for objects of class PersonalInformation
     *
     * @param name    String
     * @param surname String
     * @param phone   Integer
     * @param age Integer
     */
    public PersonalInformation(String name, String surname, Integer phone, Integer age) {
        this(name,surname,phone);
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
     * Comprueba si el campo pasado como parametro tiene la longitud
     * especificada por los parametros min y max
     * @param min - longitud minima del integer
     * @param max - longitud maxima del integer
     * @param checkerValue - Integer a comprobar
     * @return boolean  true si el campo esta en el intervalo
     */
    private boolean isValid(Integer min, Integer max,Integer checkerValue){
        return new IntegerLimited(min,max).check(checkerValue) != null;
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
        if(this.isValid(9,9,phone)){
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

    public Integer getAge() {
        return age;
    }

    public ClinicError setAge(Integer age) {
        ClinicError error = new ClinicError();
        if(age != null) {
            if(isValid(1,3,age)) {
                this.age = age;
            } else{
                error.add(new ErrorIntegerOutOfBounds());
            }
        } else {
            error.add(new ErrorFieldCantBeBlank());
        }
        return error;
    }
}
