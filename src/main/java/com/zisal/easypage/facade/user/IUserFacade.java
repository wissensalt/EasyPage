package com.zisal.easypage.facade.user;

import com.zisal.easypage.model.UserEntity;

import javax.ejb.Remote;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@Remote
public interface IUserFacade {

    void register(UserEntity userEntity);

    int login(UserEntity userEntity);
}
