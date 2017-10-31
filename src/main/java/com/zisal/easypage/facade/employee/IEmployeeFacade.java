package com.zisal.easypage.facade.employee;


import com.zisal.easypage.model.EmployeeEntity;
import com.zisal.easypage.facade.IGenericFacade;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Achmad Fauzi on 9/14/2015 : 6:13 AM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 */
@Remote
public interface IEmployeeFacade extends IGenericFacade {

    List<EmployeeEntity> getAllEmployee();

}
