package models;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Su objetivo es el de gestionar las fechas y ofrecer operaciones
 * de alto nivel a la clase agenda.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calendar {
    // instance variables - replace the example below with your own
    private java.util.Calendar calendar = java.util.Calendar.getInstance();
    private final DateTimeFormatter dateTimeFormatter;
    public final Integer MAX_DAYS_ON_WEEK = 7;

    /**
     * Constructor for objects of class Calendar
     */
    public Calendar() {
        this.setCalendarTimeNow();
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    protected java.util.Calendar getJavaCalendar() {
        return this.calendar;
    }

    public Calendar addMonths(int month) {
        assert (month >= 0);
        this.getJavaCalendar().add(java.util.Calendar.MONTH, month);
        return this;
    }

    protected void setCalendarTimeNow() {
        LocalDateTime localDateTime = LocalDateTime.now(this.getZoneId());
        this.getJavaCalendar().set(
                localDateTime.getYear(),
                localDateTime.getMonth().ordinal(),
                localDateTime.getHour(),
                localDateTime.getMinute(),
                localDateTime.getSecond()
        );
    }

    protected ZoneOffset getZoneOffset() {
        return this.getInstant().atZone(this.getZoneId()).getOffset();
    }

    private Instant getInstant() {
        return this.getJavaCalendar().toInstant();
    }

    private ZoneId getZoneId() {
        return this.getJavaCalendar().getTimeZone().toZoneId();
    }

    public long durationBetweenDays(LocalDate startDate, LocalDate finishDate) {
        assert (startDate != null && finishDate != null);
        assert (!startDate.isAfter(finishDate));
        return Duration.between(
                startDate.atTime(this.getLocaleTime()),
                finishDate.atTime(this.getLocaleTime())
        ).toDays();
    }

    private LocalTime getLocaleTime() {
        return LocalTime.now(this.getZoneId());
    }

    private LocalDate getCalendarInLocalDate() {
        return this.getInstant().atZone(this.getZoneId()).toLocalDate();
    }

    public LocalDate nextWeek() {
        int days = this.getJavaCalendar().getFirstDayOfWeek();
        this.addDays(days);
        return LocalDate.ofEpochDay(this.getCalendarEpochMili());
    }

    public void addDays(int days) {
        assert (days > 0);
        this.getJavaCalendar().add(java.util.Calendar.DAY_OF_MONTH, days);
    }

    protected Long getCalendarEpochMili() {
        return this.getInstant().toEpochMilli();
    }

    public void addYears(int years) {
        assert (years > 0);
        this.getJavaCalendar().add(
                java.util.Calendar.YEAR,
                this.getJavaCalendar().getActualMaximum(java.util.Calendar.YEAR) + years
        );
    }

    public void setDate(String stringDate) {
        assert (stringDate != null);
        assert (!stringDate.isEmpty());
        LocalDate date = LocalDate.parse(stringDate);
        this.getJavaCalendar().setTimeInMillis(date.toEpochDay());
    }

    public String getFormatedDate() {
        return this.getDateTimeFormatter().format(this.getCalendarInLocalDate());
    }

    protected DateTimeFormatter getDateTimeFormatter() {
        return this.dateTimeFormatter;
    }

    public boolean isInSameWeek(LocalDate dateOfReference, LocalDate dateToInvestigate) {
        assert (dateToInvestigate != null);
        if (dateOfReference == null) {
            return false;
        }
        if (this.isDurationHigherOfOneWeek(dateOfReference, dateToInvestigate)) {
            return false;
        } else if (this.dateOfReferenceisMenor(dateOfReference, dateToInvestigate) &&
                this.dateToInvestigateIsHiggherInDayOfWeek(dateOfReference, dateToInvestigate)) {
            return false;
        }
        return true;
    }

    private boolean isDurationHigherOfOneWeek(LocalDate dateOfReference, LocalDate dateToInvestigate) {
        return this.durationBetweenDays(dateOfReference, dateToInvestigate) > MAX_DAYS_ON_WEEK;
    }

    private boolean dateToInvestigateIsHiggherInDayOfWeek(LocalDate dateOfReference, LocalDate dateToInvestigate) {
        return dateOfReference.getDayOfWeek().ordinal() > dateToInvestigate.getDayOfWeek().ordinal();
    }

    private boolean dateOfReferenceisMenor(LocalDate dateOfReference, LocalDate dateToInvestigate) {
        return dateOfReference.getDayOfMonth() <= dateToInvestigate.getDayOfMonth();
    }
}
