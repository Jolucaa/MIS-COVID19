package clinic.views.menus.main.management;

import clinic.controllers.PatientController;
import clinic.views.menus.CreateLine;
import clinic.views.menus.Menu;
import clinic.views.menus.algorithms.creation.CreatePatient;


public class MenuManagement extends Menu {

    @Override
    protected void addCommands() {
        this.add(new CreateLine("Crear paciente").setAlgorithm(new CreatePatient(new PatientController())));
    }
}
