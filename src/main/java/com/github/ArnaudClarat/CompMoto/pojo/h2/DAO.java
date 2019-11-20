package com.github.ArnaudClarat.CompMoto.pojo.h2;

import java.util.Collection;

public interface DAO<T> {
    T find(long id); //READ

    T save(T object); //CREATE

    T update(T object); //UPDATE

    boolean delete(T object); //DELETE

    void saveAll(Collection<T> collection); //SAVE ALL
}
