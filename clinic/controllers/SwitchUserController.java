package clinic.controllers;

import clinic.models.users.User;

/**
 * Write a description of class SwitchUserController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SwitchUserController extends Controller {

    public void switchUser(User user) {
        this.getSession().setUser(user);
    }
}
