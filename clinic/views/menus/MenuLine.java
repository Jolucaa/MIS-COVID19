package clinic.views.menus;

public abstract class MenuLine {
    private Receptor receptor;
    private String title;

    protected MenuLine(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public abstract void execute();

    protected Receptor getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }
}
