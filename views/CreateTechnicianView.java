package views;

import controllers.CreateTechnicianController;

public class CreateTechnicianView extends ClinicView{


    public void interact(CreateTechnicianController createTechnicianController){
        this.writeConsole("Rellene los campos para crear un tecnico");
        createTechnicianController.create(new PersonalInformationView().interact(createTechnicianController.getPersonalInformationController()));

    }

    @Override
    protected void write() {
        this.writeConsole("Tecnico creado satisfactoriamente");
    }
}
