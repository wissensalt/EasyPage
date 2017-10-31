package com.zisal.easypage.dao.user;

import com.zisal.easypage.dao.GenericDAOJPAImpl;
import com.zisal.easypage.model.UserEntity;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@Named(value = "userDAO")
public class UserDAOImpl extends GenericDAOJPAImpl<UserEntity, BigInteger> implements IUserDAO {

    @Override
    public int doLogin(String p_UserName, String p_Password) {
        Query query = entityManager.createQuery("select a from UserEntity a where a.userName = :userName and a.userPassword = :userPassword");
        query.setParameter("userName", p_UserName);
        query.setParameter("userPassword", p_Password);
        List<UserEntity> userEntities = query.getResultList();
        if (userEntities.size() > 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public UserEntity getUser(String p_UserName) {
        Query query = entityManager.createQuery("select a from UserEntity a where a.userName = :userName");
        query.setParameter("userName", p_UserName);
        return (UserEntity) query.getSingleResult();
    }
}
