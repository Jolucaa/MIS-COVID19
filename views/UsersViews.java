package views;

import controllers.NurseController;
import controllers.PatientController;
import controllers.PersonalInformationController;
import controllers.TechnicianController;

public interface UsersViews {
    void visit(NurseController nurseController);

    void visit(PersonalInformationController personalInformationController);

    void visit(PatientController patientController);

    void visit(TechnicianController technicianController);
}
