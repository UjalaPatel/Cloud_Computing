/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customerfront.service;

import com.mycompany.customermp.entity.Tblcustomer;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author ASUS
 */
@RegisterRestClient(configKey = "customerClient",baseUri = "http://localhost:8080/customerMP/rest/customer")
public interface customerClient {
    
    @GET
    @Path("/{condition}/{rating}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tblcustomer> getCustomers(@PathParam("condition") String condition,@PathParam("rating") int rating);
}
