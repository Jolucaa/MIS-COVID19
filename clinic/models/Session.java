package clinic.models;

import clinic.models.users.Administrator;
import clinic.models.users.User;

public class Session {
    private static Session session = null;
    private Administrator administrator;
    private States states = States.INITIAL;
    private User user;

    public static Session getInstance() {
        if (Session.session == null) {
            Session.session = new Session();
        }
        return Session.session;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public States getState() {
        return states;
    }

    public void setState(States states) {
        this.states = states;
    }

    public Administrator getAdministrator() {
        return this.administrator;
    }

    public void setAdministrator(Administrator admin) {
        this.administrator = admin;
    }
}
