package clinic.views.menus;

public class ExitLine extends MenuLine {
    private boolean closed = false;

    ExitLine() {
        super("Salir");
    }

    public boolean isClosed() {
        return closed;
    }

    @Override
    public void execute() {
        this.close();
    }

    public void close() {
        closed = true;
    }

    public void reset() {
        this.closed = false;
    }
}
