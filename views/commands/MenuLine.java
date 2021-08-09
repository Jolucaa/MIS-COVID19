package views.commands;

import views.ClinicView;

public abstract class MenuLine {
    private ClinicView receptor;

    public abstract String getTitle();

    public abstract void execute();

    protected ClinicView getReceptor() {
        return receptor;
    }

    public void setReceptor(ClinicView clinicView) {
        this.receptor = clinicView;
    }
}
