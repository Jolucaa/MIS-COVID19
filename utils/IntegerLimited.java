package utils;

/**
 * Write a description of class IntegerLimitedDialog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegerLimited {
    // instance variables - replace the example below with your own
    private final Integer min;
    private final Integer max;

    /**
     * Constructor for objects of class IntegerLimitedDialog
     */
    public IntegerLimited(Integer min, Integer max) {
        assert (min != null);
        assert (max != null);
        this.min = min;
        this.max = max;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param number a sample parameter for a method
     * @return Integer if value is between interval otherwise null
     */
    public boolean check(Integer number) {
        if (number == null) {
            return false;
        }
        return min <= number && number <= max;
    }
}
