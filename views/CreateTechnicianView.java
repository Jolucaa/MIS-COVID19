package views;

import controllers.CreateTechnicianController;

public class CreateTechnicianView extends ClinicView{
    /**
     * Constructor for objects of class StartView
     */
    public CreateTechnicianView() {
    }

    public void interact(CreateTechnicianController createTechnicianController){
        this.writeConsole("Rellene los campos para crear un tecnico");
        createTechnicianController.create(new PersonalInformationView().interact());

    }

    @Override
    protected void write() {
        this.writeConsole("Tecnico creado satisfactoriamente");
    }
}
