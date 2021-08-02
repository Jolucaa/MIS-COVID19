package utils;

/**
 * Write a description of class Output here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Output<T> {
    // instance variables - replace the example below with your own
    private static Output output = null;


    public static Output getOutput() {
        return output == null ? new Output() : output;
    }

    public void write(T generic) {
        System.out.print(generic);
    }

    public void writeln() {
        System.out.println();
    }

    public void writeErr(Exception exception) {
        System.err.print(exception);
    }

    ;
}
