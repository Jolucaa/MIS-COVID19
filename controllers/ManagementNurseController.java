package controllers;

import models.Nurse;
import models.Reception;
import views.MainView;

import java.util.List;

public class ManagementNurseController extends Controller{

    public ManagementNurseController(Reception reception) {
        super(reception);
    }

    public List<Nurse> getNursesAvailables(){
        return this.getReception().getNursesAvailable();
    }

    @Override
    public void interact(MainView viewVisitor) {

    }
}
