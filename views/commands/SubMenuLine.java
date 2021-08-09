package views.commands;

public class SubMenuLine extends MenuLine {
    private String title;

    public SubMenuLine(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void execute() {
        this.getReceptor();
    }
}
