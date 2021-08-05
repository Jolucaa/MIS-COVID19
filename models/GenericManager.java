package models;

import utils.Console;

import java.util.ArrayList;

public abstract class GenericManager<T> {

    public void register(T object) {
        if (!this.isRegistered(object)) {
            this.getArrayList().add(this.create(this.getPersonalInformation(object)));
        } else {
            this.edit(this.getId(object));
        }
    }

    protected abstract PersonalInformation getPersonalInformation(T object);

    protected abstract ArrayList<T> getArrayList();

    protected abstract Integer getId(T object);

    public abstract T create(PersonalInformation personalInformation);

    public void add(T object) {
        this.getArrayList().add(object);
    }

    public void edit(Integer objectId) {
        assert (objectId != null);
        assert (objectId >= 0);
        T person = this.getPerson(objectId);
    }

    protected T getPerson(Integer objectId) {
        assert (objectId != null);
        assert (objectId >= 0);
        assert (this.getArrayList().isEmpty());

        return this.search(objectId);
    }

    protected T search(Integer objectId) {
        assert (objectId != null);
        assert (objectId >= 0);

        for (T object : this.getArrayList()) {
            if (this.getId(object).equals(objectId)) {
                return object;
            }
        }
        return null;
    }

    protected boolean isRegistered(T object) {
        return this.search(this.getId(object)) != null;
    }
}
