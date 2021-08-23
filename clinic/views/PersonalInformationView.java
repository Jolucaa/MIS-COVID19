package clinic.views;

import clinic.controllers.PersonalInformationController;
import clinic.models.errors.ClinicError;
import clinic.models.errors.ErrorFieldCantBeBlank;
import clinic.models.errors.ErrorIntegerOutOfBounds;
import clinic.models.users.PersonalData;
import utils.IntegerLimited;

public class PersonalInformationView extends ClinicView {
    private static final Integer PHONE_MIN_LONGITUDE = 100000000;
    private static final Integer PHONE_MAXIM_LONGITUDE = 999999999;
    private static final Integer AGE_MAXIM = 99;
    private static final Integer AGE_MIN = 0;
    private ClinicError error;

    public PersonalData interact(PersonalInformationController personalInformationController) {
        this.error = new ClinicError();
        String name = this.getName();
        String surname = this.getSurname();
        Integer phone = this.getPhone();
        Integer age = this.getAge();
        this.validateInputs();
        personalInformationController.registerData(name, surname, phone, age);
        return personalInformationController.getPersonalInformation();
    }

    private void validateInputs() {
        if (!error.isStackEmpty()) {
            this.getConsole().writeErr(error.buildErrorTrace());
            this.interact(this.getPersonalInformationController());
        }
    }

    private PersonalInformationController getPersonalInformationController() {
        return new PersonalInformationController();
    }

    private String getName() {
        String name = this.getConsole().readString("Introduce el nombre: ");
        if (!this.isStringValid(name)) {
            error.add(new ErrorFieldCantBeBlank());
        }
        return name;
    }

    private boolean isStringValid(String string) {
        if (string == null) {
            return false;

        } else {
            return !string.isEmpty();
        }
    }

    private String getSurname() {
        String surname = this.getConsole().readString("Introduce el apellido: ");
        if (!this.isStringValid(surname)) {
            error.add(new ErrorFieldCantBeBlank());
        }
        return surname;
    }

    private Integer getPhone() {
        Integer phone = this.getConsole().readInteger("Introduce el telefono: ");
        if (!this.isValid(PHONE_MIN_LONGITUDE, PHONE_MAXIM_LONGITUDE, phone)) {
            error.add(new ErrorIntegerOutOfBounds());
        }
        return phone;
    }

    /**
     * Comprueba si el campo pasado como parametro tiene la longitud
     * especificada por los parametros min y max
     *
     * @param min          - longitud minima del integer
     * @param max          - longitud maxima del integer
     * @param checkerValue - Integer a comprobar
     * @return boolean  true si el campo esta en el intervalo
     */
    private boolean isValid(Integer min, Integer max, Integer checkerValue) {
        return new IntegerLimited(min, max).check(checkerValue);
    }

    private Integer getAge() {
        Integer age = this.getConsole().readInteger("Introduce la edad: ");
        if (!isValid(AGE_MIN, AGE_MAXIM, age)) {
            error.add(new ErrorIntegerOutOfBounds());
        }
        return age;
    }

    @Override
    public void write() {
        this.writeConsole("Porfavor rellene los siguientes datos");
    }

    @Override
    public void interact() {
        this.interact(this.getPersonalInformationController());
    }
}
