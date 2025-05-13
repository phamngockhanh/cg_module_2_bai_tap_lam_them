package repository;

import java.util.List;

public interface IRepo<T>{
    List<T> findAll();
    void add(T t);
    List<T> search(String idOrName);
    boolean delete(String registerNumber);
    boolean findId(String registerNumber);
}
