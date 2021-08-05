package models;

public abstract class IdentifierGenericFamily<T extends MedicalProcedure>{
    private StatesIdentifierFamily state = StatesIdentifierFamily.INITIAL;


    private T familyObject;

    private void setState(StatesIdentifierFamily state){
        this.state = state;
    }

    private StatesIdentifierFamily getState() {
        return state;
    }

    public void accept(MedicalProcedure medicalProcedure){
        if(this.getState() == StatesIdentifierFamily.RESET){
            this.reset();
        }
        medicalProcedure.identifyFamily(this);
    }

    public void identify(T familyObject){
        assert(this.getState() == StatesIdentifierFamily.INITIAL);
        this.setFamilyObject(familyObject);
    }

    private void setFamilyObject(T familyObject) {
        this.familyObject = familyObject;
        this.setState(StatesIdentifierFamily.IS_VALUE);
    }

    public T getAndRenewValue() {
        this.setState(StatesIdentifierFamily.RESET);
        return this.getFamilyObject();
    }

    private T getFamilyObject() {
        assert(this.getState() == StatesIdentifierFamily.IS_VALUE);
        return this.familyObject;
    }

    public boolean isBelongsFamily() {
        assert(this.getState() == StatesIdentifierFamily.IS_VALUE);
        return this.getFamilyObject() != null;
    }

    private void reset() {
        assert(this.getState() == StatesIdentifierFamily.RESET);
        this.setFamilyObject(null);
        this.setState(StatesIdentifierFamily.INITIAL);
    }
}
