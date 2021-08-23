package utils;

/**
 * Write a description of class Output here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Output {
    // instance variables - replace the example below with your own
    private static Output output = null;


    public static Output getOutput() {
        if (output == null) {
            output = new Output();
        }
        return output;
    }

    public void write(String generic) {
        System.out.print(generic);
    }

    public void writeln() {
        System.out.println();
    }

    public void writeErr(String string) {
        System.err.println(string);
    }
}
