package com.mycompany.employeemp.service;

import com.mycompany.employeemp.model.employeeModel;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("emp")
@RequestScoped
public class employeeService {

    @Inject employeeModel em;
    @Inject @RestClient departmentClient sc;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> showEmployees()
    {   
        Collection<Integer> allids = sc.showDepartments();
        return em.getEmp(allids);
    }
    
    @POST
    @Path("addEmp/{employeeName}/{gender}/{salary}/{joiningDate}/{departmentID}")
    public void addEmp(@PathParam("employeeName") String employeeName,@PathParam("gender") String gender,
            @PathParam("salary") int salary,@PathParam("joiningDate") String joiningdate,@PathParam("departmentID") int departmentID)
    {
        em.addEmp(employeeName, gender, salary, joiningdate, departmentID);
    }        
    

}
