package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write a description of class Entrada here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Reader {
    // instance variables - replace the example below with your own
    private static Reader reader = null;
    private BufferedReader bufferReader;

    public static Reader getLector() {
        return reader == null ? new Reader() : reader;
    }

    /**
     * Constructor for objects of class Lectura
     */
    private Reader() {
        // initialise instance variables
        bufferReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readString() throws Exception {
        return bufferReader.readLine();
    }

    public Integer readInteger() throws Exception {

        return Integer.parseInt(this.readString());

    }

    public Double readDouble() throws Exception {

        return Double.parseDouble(this.readString());

    }

    public Float readFloat() throws Exception {

        return Float.parseFloat(this.readString());

    }

    public Character readChar() throws Exception {

        return (char) bufferReader.read();
    }

    public Long readLong() throws Exception {
        return Long.parseLong(this.readString());
    }

}
