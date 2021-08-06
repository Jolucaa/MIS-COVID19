package controllers;

import models.Person;
import models.PersonalInformation;
import models.Reception;
import models.errors.ClinicError;
import views.MainView;

import java.lang.reflect.Method;

public class PersonalInformationController extends Controller{
    private PersonalInformation personalInformation;

    protected PersonalInformationController(Reception reception) {
        super(reception);
        personalInformation = new PersonalInformation();
    }

    @Override
    public void interact(MainView viewVisitor) {
        viewVisitor.visit(this);
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
