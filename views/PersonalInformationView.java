package views;

import controllers.PersonalInformationController;
import models.PersonalInformation;
import models.errors.ClinicError;
import utils.Console;

public class PersonalInformationView extends ClinicView{
    public PersonalInformation interact(PersonalInformationController personalInformationController){
        this.write();
        String name = this.getConsole().readString("Introduce un nombre: ");
        String surname = this.getConsole().readString("Introduce un apellido: ");
        Integer phone = this.getConsole().readInteger("Introduce un telefono: ");
        ClinicError error = personalInformationController.registerData(name,surname,phone);
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
