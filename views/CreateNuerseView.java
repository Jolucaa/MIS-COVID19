package views;

import controllers.CreateNurseController;
import utils.Console;

public class CreateNuerseView {
    /**
     * Constructor for objects of class StartView
     */
    public CreateNuerseView() {
    }

    public void interact(CreateNurseController createNurseController){
        createNurseController.create(new PersonalInformationView().interact());
        Console.getConsole().write("Enfermero/a creado satisfactoriamente");
    }
}
