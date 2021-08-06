package views;

import controllers.PersonalInformationController;
import models.PersonalInformation;
import models.errors.ClinicError;
import utils.Console;

public class PersonalInformationView extends ClinicView{
    public PersonalInformation interact(PersonalInformationController personalInformationController){
        this.write();
        String name = this.getConsole().readString("Introduce el nombre: ");
        String surname = this.getConsole().readString("Introduce el apellido: ");
        Integer phone = this.getConsole().readInteger("Introduce el telefono: ");
        Integer age = this.getConsole().readInteger("Introduce la edad: ");
        ClinicError error = personalInformationController.registerData(name,surname,phone,age);
        if(!error.isStackEmpty()){
            error.buildErrorTrace();
            this.interact(personalInformationController);
        }
        return personalInformationController.getPersonalInformation();
    }

    @Override
    protected void write() {
        this.writeConsole("Porfavor relene los siguientes datos");
    }
}
