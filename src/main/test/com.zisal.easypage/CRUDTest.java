package com.zisal.easypage;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@RunWith(Arquillian.class)
public class CRUDTest {

    /*@Inject
    IEmployeeService iEmployeeService;*/
    @Inject
    Greeting greeting;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                //.addClass(IEmployeeService.class)
                .addClass(Greeting.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testGreeting(){
        /*List<EmployeeEntity> employeeEntities = iEmployeeService.getAllEmployee();
        System.out.println("Employee Size : " + employeeEntities.size());
        for(EmployeeEntity employeeEntity : employeeEntities){
            System.out.println(employeeEntities.toString());
        }*/
        greeting.greet(System.out, "Fauzi");
    }
}
