package clinic.views;

import clinic.controllers.NurseController;
import clinic.controllers.PersonalInformationController;
import utils.Console;

public class CreateNurseView {

    public void interact() {
        new NurseController().create(new PersonalInformationView().interact(new PersonalInformationController()));
        Console.getConsole().write("Enfermero/a creado satisfactoriamente");
    }
}
