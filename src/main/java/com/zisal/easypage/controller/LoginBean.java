package com.zisal.easypage.controller;


import com.zisal.easypage.model.EmployeeEntity;
import com.zisal.easypage.model.UserEntity;
import com.zisal.easypage.facade.employee.IEmployeeFacade;
import com.zisal.easypage.facade.user.IUserFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ladies Man on 1/12/2016.
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable{

    private static final long serialVersionUID = -4846494240925927448L;

    Logger logger = Logger.getLogger(LoginBean.class.getName());

    private String userName;
    private String password;

    @EJB
    IUserFacade iUserFacade;

    @EJB
    IEmployeeFacade iEmployeeFacade;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doLogin(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(getUserName());
        userEntity.setUserPassword(getPassword());
        logger.log(Level.INFO, userEntity.toString());
        if (iUserFacade.login(userEntity) == 1){
            logger.log(Level.INFO, "success");
            return "/pages/public/success/success_login.xhtml";
        }else{
            logger.log(Level.INFO, "username || password is invalid");
            return "/pages/public/login/login_error.xhtml";
        }
    }

    public String register(){
        return "/pages/public/register/register.xhtml";
    }

    public void displayAllEmployee(){
        List<EmployeeEntity> employeeEntities = iEmployeeFacade.getAllEmployee();
        for(EmployeeEntity employeeEntity : employeeEntities){
            System.out.println(employeeEntity);
        }
    }
}
