package views.strategy;

import controllers.PersonalInformationController;
import models.PersonalInformation;
import views.PersonalInformationView;

public abstract class Create implements StrategyAlghoritm {
    protected PersonalInformation obtainPersonalInformation(PersonalInformationController personalInformationController) {
        return new PersonalInformationView().interact(personalInformationController);
    }
}
