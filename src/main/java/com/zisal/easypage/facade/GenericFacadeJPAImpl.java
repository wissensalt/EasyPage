package com.zisal.easypage.facade;

import com.zisal.easypage.dao.IGenericDAO;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Achmad Fauzi on 9/14/2015 : 5:48 AM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 * @param <DATA>
 * @param <KEY>
 */
public abstract class GenericFacadeJPAImpl<DATA extends Serializable, KEY extends Serializable> implements IGenericFacade<DATA, KEY> {

    private IGenericDAO genericDAO;

    @PostConstruct
    private void initBaseService() {
        genericDAO = initDAO();
    }

    protected abstract IGenericDAO initDAO();

    @Override
    public void save(DATA data) {
        genericDAO.save(data);
    }

    @Override
    public void merge(DATA data) {
        genericDAO.merge(data);
    }

    @Override
    public DATA read(Class<DATA> dataClass, KEY id) {
        return (DATA) genericDAO.read(dataClass, id);
    }

    @Override
    public void delete(DATA data) {
        genericDAO.delete(data);
    }

    @Override
    public void deleteById(Class<DATA> dataClass, KEY id) {
        delete(read(dataClass, id));
    }

    @Override
    public void deleteAllEntities(Class<DATA> entityType) {
        genericDAO.deleteAllEntities(entityType);
    }

    @Override
    public List<DATA> loadAllEntity(Class<DATA> dataClass) {
        return genericDAO.loadAllEntity(dataClass);
    }


}
