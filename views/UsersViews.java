package views;

import controllers.CreatePatientController;
import controllers.NurseController;
import controllers.PersonalInformationController;
import controllers.TechnicianController;

public interface UsersViews {
    void visit(NurseController nurseController);

    void visit(PersonalInformationController personalInformationController);

    void visit(CreatePatientController createPatientController);

    void visit(TechnicianController technicianController);
}
