package models;

public enum DiagnosticTestInformation {
    MIN_ANTIBODIES(0),
    MAX_ANTIBODIES (10),
    ALERT_ANTIBODIES (2),
    NURSE_MAX_NUM_DIAGNOSTIC(5),
    TECHNICIAN_MAX_NUM_DIAGNOSTIC(4),
    PCR_TIME_BETWEEN_ANOTHER(4),
    SEROLOGIC_TIME_BETWEEN_ANOTHER(180),
    LOCKDOWN_TIME(10);

    DiagnosticTestInformation(Integer ordinal) {
        this.ordinal = ordinal;
    }

    private Integer ordinal;

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }
}
