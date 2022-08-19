package service;

import java.util.List;

public interface IGeneric<T> {

    List<T> findAll();

    void save(T e);

}
