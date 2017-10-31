package com.zisal.easypage.dao.employee;


import com.zisal.easypage.dao.IGenericDAO;
import com.zisal.easypage.model.EmployeeEntity;

import java.util.List;

/**
 * Created by Achmad Fauzi on 9/14/2015 : 6:10 AM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 */
public interface IEmployeeDAO extends IGenericDAO{

    List<EmployeeEntity> getAllEmployee();
}
