package models;

import models.filters.Filter;

import java.util.ArrayList;
import java.util.List;

public class ClinicList<T> {

    public List<T> getList(List<T> listToFilter, Filter filter) {
        ArrayList<T> listFiltered = new ArrayList<>();
        for (int i = 0; i <= listToFilter.size(); i++) {
            listFiltered.add(filter.isValid(listToFilter.get(i)));
        }
        return listFiltered;
    }
}
