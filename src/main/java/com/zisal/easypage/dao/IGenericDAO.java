package com.zisal.easypage.dao;

import java.util.List;

/**
 * Created by Achmad Fauzi on 9/14/2015 : 5:17 AM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 * @param <DATA>
 * @param <KEY>
 */
public interface IGenericDAO<DATA, KEY> {

    void save(DATA data);

    void merge(DATA data);

    DATA read(Class<DATA> dataClass, KEY id);

    void delete(DATA data);

    void deleteById(Class<DATA> dataClass, KEY id);

    void deleteAllEntities(Class<DATA> entityType);

    List<DATA> loadAllEntity(Class<DATA> dataClass);
}
