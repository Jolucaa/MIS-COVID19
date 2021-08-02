package views;

import models.PersonalInformation;
import utils.Console;
public class AdminCreatorView extends OperationView{
    private PersonalInformationView personalInformationView;

    public AdminCreatorView() {
        personalInformationView = new PersonalInformationView();
    }

    public PersonalInformation interact(){
        PersonalInformation personalInformation = this.personalInformationView.interact();
        Console.getConsole().write("Se ha creado un administrador: " + personalInformation.getNameFormat());
        return personalInformation;
    }
}
