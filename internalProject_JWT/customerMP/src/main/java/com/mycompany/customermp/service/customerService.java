package com.mycompany.customermp.service;

import com.mycompany.customermp.entity.Tblcustomer;
import com.mycompany.customermp.model.customerModel;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class customerService {

    @Inject
    customerModel cm;
    
    @GET
    @Path("/{condition}/{rating}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("User")
    public Collection<Tblcustomer> getCustomers(@PathParam("condition") String condition,@PathParam("rating") int rating) {
        return cm.getC(condition, rating);
    }

}
