package models.filters;

public abstract class Filter {
    public abstract <T>  T isValid(T t);
}
