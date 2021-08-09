package models;

import java.util.List;

public abstract class GenericManager<T> {

    public void register(T object) {
        if (!this.isRegistered(object)) {
            this.getList().add(this.create(this.getPersonalInformation(object)));
        } else {
            this.edit(this.getId(object));
        }
    }

    protected abstract PersonalInformation getPersonalInformation(T object);

    protected abstract List<T> getList();

    protected abstract Integer getId(T object);

    public abstract T create(PersonalInformation personalInformation);

    public void add(T object) {
        this.getList().add(object);
    }

    public void edit(Integer objectId) {
        assert (objectId != null);
        assert (objectId >= 0);
        T person = this.getPerson(objectId);
    }

    protected T getPerson(Integer objectId) {
        assert (objectId != null);
        assert (objectId >= 0);
        assert (this.getList().isEmpty());

        return this.search(objectId);
    }

    protected T search(Integer objectId) {
        assert (objectId != null);
        assert (objectId >= 0);

        for (T object : this.getList()) {
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
