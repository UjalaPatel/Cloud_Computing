package com.mycompany.departmentmp.service;

import com.mycompany.departmentmp.model.departmentModel;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("dept")
@RequestScoped
public class departmentService {

    @Inject departmentModel dm;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Integer> showDeaprtments() {
        return dm.getAvailableIds();
    }

}
