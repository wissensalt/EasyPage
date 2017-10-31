package com.zisal.easypage.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Achmad Fauzi on 9/14/2015 : 5:18 AM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 *
 * @param <DATA>
 * @param <KEY>
 */
public class GenericDAOJPAImpl<DATA, KEY> implements IGenericDAO<DATA, KEY> {

    protected Logger logger = LoggerFactory.getLogger(GenericDAOJPAImpl.class);

    @PersistenceContext(unitName = "easy_page_pu")
    protected EntityManager entityManager;

    @Override
    public void save(DATA data) {
        if (data != null){
            this.entityManager.persist(data);
            this.entityManager.flush();
        }else {
            logger.warn("warning", "Saved data is null");
        }
    }

    @Override
    public void merge(DATA data) {
        if (data != null){
            this.entityManager.merge(data);
            this.entityManager.flush();
        }else {
            logger.warn("warning", "Merged data is null");
        }
    }

    @Override
    public DATA read(Class<DATA> dataClass, KEY id) {
        return this.entityManager.find(dataClass, id);
    }


    @Override
    public void delete(DATA data) {
        data = this.entityManager.merge(data);
        this.entityManager.remove(data);
    }

    @Override
    public void deleteById(Class<DATA> dataClass, KEY id) {
        delete(read(dataClass, id));
    }

    @Override
    public void deleteAllEntities(Class<DATA> entityType) {
        String query = new StringBuilder("DELETE FROM ")
                .append(entityType.getSimpleName().toLowerCase())
                .append(" e")
                .toString();
        entityManager.createQuery(query).executeUpdate();
    }

    @Override
    public List<DATA> loadAllEntity(Class<DATA> dataClass) {
        Query query = entityManager.createQuery("select a from "+dataClass.getSimpleName()+ " a");
        return query.getResultList();
    }
}
