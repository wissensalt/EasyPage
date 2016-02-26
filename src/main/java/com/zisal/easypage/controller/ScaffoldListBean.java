package com.zisal.easypage.controller;

import com.zisal.easypage.facade.employee.IEmployeeFacade;
import com.zisal.easypage.model.EmployeeEntity;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@ManagedBean(name = "scaffoldBean")
@RequestScoped
public class ScaffoldListBean {

    @EJB
    IEmployeeFacade iEmployeeFacade;

    private List<EmployeeEntity> employeeEntities;
    private String employeeName;
    private String employeeAddress;
    private EmployeeEntity employeeEntity;

    private Logger logger = Logger.getLogger(ScaffoldListBean.class.getName());


    @PostConstruct
    public void initData(){
        employeeEntities = iEmployeeFacade.getAllEmployee();
    }

    public String manageEmployee(){
        return "/pages/scaffold/employee/employee_list.xhtml";
    }

    public void addEmployee(){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(getEmployeeName());
        employeeEntity.setAddress(getEmployeeAddress());
        logger.log(Level.INFO, "Saved Employee : " + employeeEntity.toString());
        iEmployeeFacade.save(employeeEntity);
        getEmployeeEntities().add(employeeEntity);
    }


    public void delete(BigInteger p_id){
        employeeEntity = (EmployeeEntity) iEmployeeFacade.read(EmployeeEntity.class, p_id);
        iEmployeeFacade.delete(employeeEntity);
        getEmployeeEntities().remove(employeeEntity);
    }

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }



}
