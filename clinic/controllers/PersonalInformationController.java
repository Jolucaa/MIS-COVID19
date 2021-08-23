package clinic.controllers;

import clinic.models.users.PersonalData;

public class PersonalInformationController {
    private PersonalData personalData;

    public PersonalInformationController() {
        personalData = new PersonalData();
    }

    public void registerData(String name, String surname, Integer phone, Integer age) {
        personalData.setName(name)
                .setSurname(surname)
                .setPhone(phone)
                .setAge(age);
    }

    public PersonalData getPersonalInformation() {
        return this.personalData;
    }
}
