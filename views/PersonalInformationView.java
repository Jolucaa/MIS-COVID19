package views;

import models.PersonalInformation;
import utils.Console;

public class PersonalInformationView extends ClinicView{
    public PersonalInformation interact(){
        this.write();
        String name = this.getConsole().readString("Introduce un nombre: ");
        String surname = this.getConsole().readString("Introduce un apellido: ");
        Integer phone = this.getConsole().readInteger("Introduce un telefono: ");
        return new PersonalInformation(name,surname,phone);
    }

    @Override
    protected void write() {
        this.writeConsole("Porfavor relene los siguientes datos");
    }
}
