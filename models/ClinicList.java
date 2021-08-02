package models;

import java.util.ArrayList;
import java.util.List;
import models.filters.Filter;

public class ClinicList<T> {

    public ArrayList<T> getList(List<T> listToFilter, Filter filter){
        ArrayList<T> listFiltered = new ArrayList<>();
        for(int i = 0; i <= listToFilter.size(); i++){
            listFiltered.add(filter.isValid(listToFilter.get(i)));
        }
        return listFiltered;
    }
}
