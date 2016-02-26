package com.zisal.easypage.facade.employee;

import javax.ejb.Stateless;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@Stateless
public class ManageEmployeeServiceImpl implements IManageEmployee {

    @Override
    public void showData() {
        System.out.println("Hello User");
    }
}
