package com.zisal.easypage.facade.employee;

import com.zisal.easypage.dao.IGenericDAO;
import com.zisal.easypage.dao.employee.IEmployeeDAO;
import com.zisal.easypage.model.EmployeeEntity;
import com.zisal.easypage.facade.GenericFacadeJPAImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Achmad Fauzi on 9/14/2015 : 6:14 AM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 */
@Stateless
public class EmployeeFacadeImpl extends GenericFacadeJPAImpl implements IEmployeeFacade {

    @EJB
    IManageEmployee iManageEmployee;

    @Inject
    @Named(value = "employeeDAO")
    private IEmployeeDAO iEmployeeDAO;

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return iEmployeeDAO.getAllEmployee();
    }

    @Override
    protected IGenericDAO initDAO() {
        return iEmployeeDAO;
    }
}
