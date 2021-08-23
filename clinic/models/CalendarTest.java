package clinic.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * The test class CalendarTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CalendarTest {
    private final Calendar calendar;


    /**
     * Default constructor for test class CalendarTest
     */
    public CalendarTest() {
        calendar = new Calendar();
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testDurationBetweenDays() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse("01/08/1990", dateTimeFormatter);
        LocalDate finishDate = LocalDate.parse("01/09/1990", dateTimeFormatter);

        Assertions.assertEquals(getCalendar().durationBetweenDays(startDate, finishDate), 31L);
    }

    private Calendar getCalendar() {
        return calendar;
    }

    @Test
    public void testGetFormatedDate() {
        Assertions.assertEquals(this.getFormatedDate(), getCalendar().getFormatedDate());
    }

    private String getFormatedDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTimeFormatter.format(this.getCalendarInLocalDate());
    }

    private LocalDate getCalendarInLocalDate() {
        return this.getInstant().atZone(this.getZoneId()).toLocalDate();
    }

    private Instant getInstant() {
        return this.getJavaCalendar().toInstant();
    }

    private ZoneId getZoneId() {
        return this.getJavaCalendar().getTimeZone().toZoneId();
    }

    private java.util.Calendar getJavaCalendar() {
        return java.util.Calendar.getInstance();
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }

}

