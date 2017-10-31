package com.zisal.easypage.controller;

import com.zisal.easypage.model.UserEntity;
import com.zisal.easypage.facade.user.IUserFacade;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@ManagedBean(name = "registerBean")
@RequestScoped
public class RegisterBean {

    private String userName;
    private String password;
    private String confirmPassword;

    @EJB
    IUserFacade iUserFacade;

    Logger logger = Logger.getLogger(RegisterBean.class.getName());

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String doRegister(){
        if (getUserName() != null){
            if (getPassword() != null){
                if (getConfirmPassword() != null){
                    if (getPassword().equals(getConfirmPassword())){
                        UserEntity userEntity = new UserEntity();
                        userEntity.setUserName(getUserName());
                        userEntity.setUserPassword(getPassword());
                        iUserFacade.register(userEntity);
                        return "/pages/public/success/success.xhtml";
                    }else{
                        logger.log(Level.INFO, "password doesn't match confirm password");
                        return "";
                    }
                }else{
                    logger.log(Level.INFO, "username is empty");
                    return "";
                }
            }else {
                logger.log(Level.INFO, "password is empty");
                return "";
            }
        }else{
            logger.log(Level.INFO, "username is empty");
            return "";
        }
    }
}
