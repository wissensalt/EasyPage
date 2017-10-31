package com.zisal.easypage.facade.user;

import com.zisal.easypage.dao.IGenericDAO;
import com.zisal.easypage.dao.user.IUserDAO;
import com.zisal.easypage.model.UserEntity;
import com.zisal.easypage.security.ISecurityUtilFacade;
import com.zisal.easypage.facade.GenericFacadeJPAImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@Stateless
public class UserFacadeImpl extends GenericFacadeJPAImpl<UserEntity, BigInteger> implements IUserFacade {

    @Inject
    @Named(value = "userDAO")
    IUserDAO iUserDAO;

    @EJB
    ISecurityUtilFacade iSecurityUtilFacade;

    private Logger logger = Logger.getLogger(UserFacadeImpl.class.getName());

    @Override
    public void register(UserEntity userEntity) {
        if (userEntity != null){
            userEntity.setUserPassword(iSecurityUtilFacade.encript(userEntity.getUserPassword()));
            iUserDAO.save(userEntity);
        }
    }

    @Override
    public int login(UserEntity userEntity) {
        if (userEntity != null) {
            UserEntity user = iUserDAO.getUser(userEntity.getUserName());
            if (user != null) {
                String password = iSecurityUtilFacade.decript(user.getUserPassword());
                if (password.equals(userEntity.getUserPassword())) {
                    return 1;
                }else{
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Override
    protected IGenericDAO initDAO() {
        return iUserDAO;
    }
}
