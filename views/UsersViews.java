package views;

import controllers.CreateNurseController;
import controllers.CreatePatientController;
import controllers.CreateTechnicianController;
import controllers.PersonalInformationController;

public interface UsersViews {
    void visit(CreateNurseController createNurseController);

    void visit(PersonalInformationController personalInformationController);

    void visit(CreatePatientController createPatientController);

    void visit(CreateTechnicianController createTechnicianController);
}
