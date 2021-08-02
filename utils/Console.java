package utils;

import java.io.IOException;

/**
 * Write a description of class Console here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Console<T> {
    // instance variables - replace the example below with your own
    private static Console consoleInstance = null;
    private Output output;
    private Reader reader;

    public static Console getConsole() {
        return consoleInstance == null ? new Console<>() : consoleInstance;
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

    public void write(T generic) {
        this.getOutput().write(generic);
    }

    public void writeln() {
        this.getOutput().writeln();
    }

    public String readString(T title) {
        try {
            this.write(title);
            this.writeln();
            return this.getReader().readString();
        } catch (Exception ioException) {
            this.getConsole().writeErr(ioException);
        }
        return this.readString(title);
    }

    public Integer readInteger(T title){
        try {
            this.write(title);
            this.writeln();
            return this.getReader().readInteger();
        } catch (Exception ioException) {
            this.getConsole().writeErr(ioException);
        }
        return this.readInteger(title);
    }

    private void writeErr(Exception exception) {
        this.getOutput().writeErr(exception);
    }

    public Character readChar(T title){
        try {
            this.write(title);
            this.writeln();
            return this.getReader().readChar();
        } catch (Exception ioException) {
            this.getConsole().writeErr(ioException);
        }
        return this.readChar(title);
    }
}
