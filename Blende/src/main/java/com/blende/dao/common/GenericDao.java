package com.blende.dao.common;

import com.blende.model.basemodel.BaseModel;

import java.util.List;

public interface GenericDao<T extends BaseModel> {

    T findOne(final int id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final int entityId);

    long count();
}
