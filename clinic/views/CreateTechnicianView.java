package clinic.views;

import clinic.controllers.PersonalInformationController;
import clinic.controllers.TechnicianController;

public class CreateTechnicianView extends ClinicView {

    @Override
    public void interact() {
        this.writeConsole("Rellene los campos para crear un tecnico");
        new TechnicianController().create(new PersonalInformationView().interact(new PersonalInformationController()));

    }

    @Override
    public void write() {
        this.writeConsole("Tecnico creado satisfactoriamente");
    }
}
