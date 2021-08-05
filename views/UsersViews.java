package views;

import controllers.CreateNurseController;
import controllers.PersonalInformationController;
import models.PersonalInformation;

public interface UsersViews {
    void visit(CreateNurseController createNurseController);

    void visit(PersonalInformationController personalInformationController);
}
