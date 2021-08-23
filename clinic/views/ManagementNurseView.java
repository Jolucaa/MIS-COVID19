package clinic.views;

import clinic.controllers.NurseController;

public class ManagementNurseView extends ClinicView {

    @Override
    public void interact() {
        switch (this.getConsole().readInteger("Seleccione un numero")) {
            case 1:
                new CreateNurseView().interact();
                break;
            case 2:
            case 3:
                this.writeList(new NurseController().getNursesAvailables());
                break;
            case 4:
        }
        this.getConsole().writeln();
    }

    @Override
    public void write() {
        this.writeConsole("--MainMenu de gestion de enfermeras/os--");
        this.writeConsole("1 Crear Enfermero/a");
        this.writeConsole("2 Modificar Enfermero/a");
        this.writeConsole("3 Eliminar Enfermero/a");
        this.writeConsole("4 MainMenu Principal");

    }
}
