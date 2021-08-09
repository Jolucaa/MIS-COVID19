package views;

import controllers.NurseController;

public class ManagementNurseView extends ClinicView {

    public void interact(NurseController nurseController) {
        this.write();
        switch (this.getConsole().readInteger("Seleccione un numero")) {
            case 1:
                new CreateNurseView().interact(nurseController);
                break;
            case 2:
                this.writeList(nurseController.getNursesAvailables(), nurseController);
                break;
            case 3:
                this.writeList(nurseController.getNursesAvailables(), nurseController);
                break;
            case 4:
            default:
                this.restart(nurseController);
        }
        this.getConsole().writeln();
    }

    @Override
    protected void write() {
        this.writeConsole("--Menu de gestion de enfermeras/os--");
        this.writeConsole("1 Crear Enfermero/a");
        this.writeConsole("2 Modificar Enfermero/a");
        this.writeConsole("3 Eliminar Enfermero/a");
        this.writeConsole("4 Menu Principal");

    }
}
