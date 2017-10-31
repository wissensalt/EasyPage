package com.zisal.easypage.security;

import javax.ejb.Local;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@Local
public interface ISecurityUtilFacade {

    String encript(String data);

    String decript(String data);
}
