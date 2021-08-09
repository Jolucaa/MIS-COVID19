package views;

import controllers.AdminController;
import models.PersonalInformation;
import utils.Console;

public class AdminCreatorView extends OperationView {
    private PersonalInformationView personalInformationView;

    public AdminCreatorView() {
        personalInformationView = new PersonalInformationView();
    }

    public PersonalInformation interact(AdminController adminController) {
        PersonalInformation personalInformation = this.personalInformationView.interact(adminController.getPersonalInformationController());
        Console.getConsole().write("Se ha creado un administrador: " + personalInformation.getNameFormat());
        return personalInformation;
    }
}
