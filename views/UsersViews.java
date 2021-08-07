package views;

import controllers.CreatePatientController;
import controllers.CreateTechnicianController;
import controllers.NurseController;
import controllers.PersonalInformationController;

public interface UsersViews {
    void visit(NurseController nurseController);

    void visit(PersonalInformationController personalInformationController);

    void visit(CreatePatientController createPatientController);

    void visit(CreateTechnicianController createTechnicianController);
}
