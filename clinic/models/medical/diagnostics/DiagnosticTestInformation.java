package clinic.models.medical.diagnostics;

public enum DiagnosticTestInformation {
    MIN_ANTIBODIES(0),
    MAX_ANTIBODIES(10),
    ALERT_ANTIBODIES(2),
    NURSE_MAX_NUM_DIAGNOSTIC(5),
    TECHNICIAN_MAX_NUM_DIAGNOSTIC(4),
    PCR_TIME_BETWEEN_ANOTHER(4),
    SEROLOGIC_TIME_BETWEEN_ANOTHER(180),
    LOCKDOWN_TIME(10);

    private Integer requirementValue;

    DiagnosticTestInformation(Integer requirementValue) {
        this.requirementValue = requirementValue;
    }

    public Integer getRequirement() {
        return requirementValue;
    }

    public void setRequirement(Integer ordinal) {
        this.requirementValue = ordinal;
    }
}
