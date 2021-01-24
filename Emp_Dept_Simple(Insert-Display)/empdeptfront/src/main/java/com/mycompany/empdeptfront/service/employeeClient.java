/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empdeptfront.service;

import java.util.Collection;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author ASUS
 */
@RegisterRestClient(configKey = "employeeClient",baseUri = "http://localhost:8080/employeeMP/rest")
@ApplicationScoped
@Path("emp")
public interface employeeClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Object[]> showEmployees();
    
    @POST
    @Path("addEmp/{employeeName}/{gender}/{salary}/{joiningDate}/{departmentID}")
    public void addEmp(@PathParam("employeeName") String employeeName,@PathParam("gender") String gender,
            @PathParam("salary") int salary,@PathParam("joiningDate") String joiningdate,@PathParam("departmentID") int departmentID);
}
