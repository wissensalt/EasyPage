package com.zisal.easypage.dao.employee;

import com.zisal.easypage.dao.GenericDAOJPAImpl;
import com.zisal.easypage.model.EmployeeEntity;

import javax.inject.Named;
import java.util.List;

/**
 * Created by Achmad Fauzi on 9/14/2015 : 6:09 AM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 */
@Named(value = "employeeDAO")
public class EmployeeDAOImpl extends GenericDAOJPAImpl implements IEmployeeDAO {

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return  entityManager.createQuery("select a from EmployeeEntity a").getResultList();
    }
}
