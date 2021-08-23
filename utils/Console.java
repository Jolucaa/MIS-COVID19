package utils;


/**
 * Write a description of class Console here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Console {
    // instance variables - replace the example below with your own
    private static Console consoleInstance = null;
    private Output output;
    private Reader reader;

    public static Console getConsole() {
        if (consoleInstance == null) {
            consoleInstance = new Console();
            return consoleInstance;
        }
        return consoleInstance;
    }

    /**
     * Constructor for objects of class Console
     */
    private Console() {
        output = Output.getOutput();
        reader = Reader.getLector();
    }

    private Output getOutput() {
        return output;
    }

    private Reader getReader() {
        return reader;
    }

    public void write(String generic) {
        this.getOutput().write(generic);
    }

    public void writeln() {
        this.getOutput().writeln();
    }

    public String readString(String title) {
        try {
            this.write(title);
            this.writeln();
            return this.getReader().readString();
        } catch (Exception ioException) {
            this.writeErr(ioException.toString());
        }
        return this.readString(title);
    }

    public Integer readInteger(String title) {
        try {
            this.write(title);
            this.writeln();
            return this.getReader().readInteger();
        } catch (Exception ioException) {
            this.writeErr(ioException.toString());
        }
        return this.readInteger(title);
    }

    public void writeErr(String string) {
        this.getOutput().writeErr(string);
    }

    public Character readChar(String title) {
        try {
            this.write(title);
            this.writeln();
            return this.getReader().readChar();
        } catch (Exception ioException) {
            this.writeErr(ioException.toString());
        }
        return this.readChar(title);
    }
}
