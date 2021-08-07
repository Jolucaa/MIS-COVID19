package views;

import controllers.AdminCreatorController;
import models.PersonalInformation;
import utils.Console;

public class AdminCreatorView extends OperationView {
    private PersonalInformationView personalInformationView;

    public AdminCreatorView() {
        personalInformationView = new PersonalInformationView();
    }

    public PersonalInformation interact(AdminCreatorController adminCreatorController) {
        PersonalInformation personalInformation = this.personalInformationView.interact(adminCreatorController.getPersonalInformationController());
        Console.getConsole().write("Se ha creado un administrador: " + personalInformation.getNameFormat());
        return personalInformation;
    }
}
