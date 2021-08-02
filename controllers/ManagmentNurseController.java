package controllers;

import models.ClinicError;
import models.Nurse;
import models.Reception;

import java.util.ArrayList;

public class ManagmentNurseController extends Controller{

    public ManagmentNurseController(Reception reception) {
        super(reception);
    }

    @Override
    public ClinicError control() {
        return null;
    }

    public ArrayList<Nurse> getNursesAvailables(){
        return this.getReception().getNursesAvailables();
    }

}
