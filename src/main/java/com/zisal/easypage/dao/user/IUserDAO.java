package com.zisal.easypage.dao.user;

import com.zisal.easypage.dao.IGenericDAO;
import com.zisal.easypage.model.UserEntity;

import java.math.BigInteger;

/**
 * Created by Ladies Man on 1/13/2016.
 */
public interface IUserDAO extends IGenericDAO<UserEntity, BigInteger>{

    int doLogin(String p_UserName, String p_Password);

    UserEntity getUser(String p_UserName);

}
