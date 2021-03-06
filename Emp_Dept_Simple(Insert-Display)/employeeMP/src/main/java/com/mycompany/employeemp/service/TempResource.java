/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeemp.service;

import com.mycompany.employeemp.model.employeeModel;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * REST Web Service
 *
 * @author ASUS
 */
@Path("temp")
@RequestScoped
public class TempResource {
    @Inject employeeModel em;
    @Inject @RestClient departmentClient sc;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> showEmployees()
    {   
        System.out.println("com.mycompany.employeemp.service.TempResource.showEmployees()");
        Collection<Integer> allids = sc.showDepartments();
        System.out.println("com.mycompany.employeemp.service.TempResource.showEmployees()"+allids);
        return em.getEmp(allids);
    }
}
