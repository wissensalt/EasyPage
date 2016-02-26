package com.zisal.easypage.controller;

import com.zisal.easypage.facade.employee.IEmployeeFacade;
import com.zisal.easypage.model.EmployeeEntity;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ladies Man on 1/15/2016.
 */
@ManagedBean(name = "scaffoldViewBean")
@SessionScoped
public class ScaffoldViewBean {

    @EJB
    IEmployeeFacade iEmployeeFacade;

    private Logger logger = Logger.getLogger(ScaffoldViewBean.class.getName());

    private EmployeeEntity employeeEntity;
    private boolean textEnabled = true;

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public String view(BigInteger p_Id){
        employeeEntity = (EmployeeEntity) iEmployeeFacade.read(EmployeeEntity.class, p_Id);
        logger.log(Level.INFO, "employee post rendered : "+employeeEntity.toString());
        return "/pages/scaffold/employee/employee_view.xhtml";
    }

    public void update(EmployeeEntity p_EmployeeEntity){
        textEnabled = true;
        iEmployeeFacade.merge(p_EmployeeEntity);
    }

    public boolean isTextEnabled() {
        return textEnabled;
    }

    public void textVisibility(BigInteger p_Id){
        employeeEntity = (EmployeeEntity) iEmployeeFacade.read(EmployeeEntity.class, p_Id);
        textEnabled = !textEnabled;
    }

    public String viewList(){
        return "/pages/scaffold/employee/employee_list.xhtml";
    }

    public void setTextEnabled(boolean textEnabled) {
        this.textEnabled = textEnabled;
    }
}
