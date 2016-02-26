package com.zisal.easypage.facade;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Achmad Fauzi on 9/14/2015 : 5:40 AM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 * @param <DATA>
 * @param <KEY>
 */
public interface IGenericFacade<DATA extends Serializable, KEY extends Serializable> {

    void save(DATA data);

    void merge(DATA data);

    DATA read(Class<DATA> dataClass, KEY id);

    void delete(DATA data);

    void deleteById(Class<DATA> dataClass, KEY id);

    void deleteAllEntities(Class<DATA> entityType);

    List<DATA> loadAllEntity(Class<DATA> dataClass);
}
