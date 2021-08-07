package views;

import controllers.TechnicianController;

public class CreateTechnicianView extends ClinicView{


    public void interact(TechnicianController technicianController) {
        this.writeConsole("Rellene los campos para crear un tecnico");
        technicianController.create(new PersonalInformationView().interact(technicianController.getPersonalInformationController()));

    }

    @Override
    protected void write() {
        this.writeConsole("Tecnico creado satisfactoriamente");
    }
}
