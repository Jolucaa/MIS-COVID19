package clinic.views;

import clinic.controllers.AdminController;
import clinic.models.users.PersonalData;
import utils.Console;

public class AdminCreatorView extends MainView {
    private PersonalInformationView personalInformationView;

    public AdminCreatorView() {
        personalInformationView = new PersonalInformationView();
    }

    public PersonalData interact(AdminController adminController) {
        PersonalData personalData = this.personalInformationView.interact(adminController.getPersonalInformationController());
        Console.getConsole().write("Se ha creado un administrador: " + personalData.getNameFormat());
        return personalData;
    }
}
