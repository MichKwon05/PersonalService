package mx.edu.utez.personalservice.model;

import mx.edu.utez.personalservice.utils.Response;

import java.util.List;
import java.util.Objects;

public interface Repository<T> {
    List<T>findAll();
    Response<T> findById(Long id);
    Response<T> save(T object);
    Response<T> update (T object);

    Response save(BeanPersonal object);

    Response update(BeanPersonal object);

    Response<T> delete (Long id);
    /*
    BeanPersonal findOne(Long id);
    boolean save(BeanPersonal object);
    boolean update(BeanPersonal object);
    boolean delete(Long id);*/
}
