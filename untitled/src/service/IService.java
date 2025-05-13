package service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    void add(T t);
    List<T> search(String idOrName);
    boolean delete(String registerNumber);
    boolean findId(String registerNumber);
}
