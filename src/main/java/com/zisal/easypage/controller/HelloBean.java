package com.zisal.easypage.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@ManagedBean(name = "helloBean")
@RequestScoped
public class HelloBean implements Serializable{
    
    private static final long serialVersionUID = -324576673206022014L;
        
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String welcome(){
        return "pages/welcome.xhtml";
    }

    public String gotoLoginPage(){
        return "/pages/public/login/login.xhtml";
    }

}
