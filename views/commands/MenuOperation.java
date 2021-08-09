package views.commands;

public class MenuOperation extends Menu {
    @Override
    protected void addCommands() {
        //this.writeConsole(" -- Menu Principal --");
        this.add(new SubMenuLine("Gestion Usuarios"));
//        this.writeConsole("1 -- Gestion de Usuarios --");
//        this.writeConsole("2 -- Gestion de Procesos Medicos --");
//        this.writeConsole("3 -- Busquedas --");
//        this.writeConsole("4 -- Salir --");
    }
}
