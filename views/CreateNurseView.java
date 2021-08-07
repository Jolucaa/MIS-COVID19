package views;

import controllers.NurseController;
import utils.Console;

public class CreateNurseView {

    public void interact(NurseController nurseController) {
        nurseController.create(new PersonalInformationView().interact(nurseController.getPersonalInformationController()));
        Console.getConsole().write("Enfermero/a creado satisfactoriamente");
    }
}
