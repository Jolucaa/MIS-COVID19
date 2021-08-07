package controllers;

import models.PersonalInformation;
import models.Reception;
import models.errors.ClinicError;

public class PersonalInformationController extends Controller{
    private PersonalInformation personalInformation;

    protected PersonalInformationController(Reception reception) {
        super(reception);
        personalInformation = new PersonalInformation();
    }

    public ClinicError registerData(String name, String surname, Integer phone,Integer age){
        ClinicError error = new ClinicError();
        error.add(personalInformation.setName(name));
        error.add(personalInformation.setSurname(surname));
        error.add(personalInformation.setPhone(phone));
        error.add(personalInformation.setAge(age));
        return error;
    }

    public PersonalInformation getPersonalInformation() {
        return this.personalInformation;
    }
}
