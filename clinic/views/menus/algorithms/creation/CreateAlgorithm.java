package clinic.views.menus.algorithms.creation;

import clinic.controllers.PersonalInformationController;
import clinic.models.users.PersonalData;
import clinic.views.PersonalInformationView;
import clinic.views.menus.algorithms.LineAlgorihtm;

public abstract class CreateAlgorithm implements LineAlgorihtm {
    protected PersonalData askPersonalInformation(PersonalInformationController personalInformationController) {
        return new PersonalInformationView().interact(personalInformationController);
    }
}
