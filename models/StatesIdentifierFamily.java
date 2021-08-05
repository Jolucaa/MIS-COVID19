package models;

public enum StatesIdentifierFamily {
    INITIAL(0),
    IS_VALUE(1),
    RESET(2);

    private final Integer value;

    StatesIdentifierFamily(Integer value) {
        this.value = value;
    }
}
