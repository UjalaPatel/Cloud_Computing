/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.departmentmp.model;

import com.mycompany.departmentmp.entity.Tbldepartment;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ASUS
 */
@Named
@ApplicationScoped
public class departmentModel {
    EntityManager em;
    Collection<Integer> availableIds;

    public departmentModel() {
        em = Persistence.createEntityManagerFactory("departmentPU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Integer> getAvailableIds() {
        availableIds = new ArrayList<>();
        Collection<Tbldepartment> dept = em.createQuery("SELECT d FROM Tbldepartment d").getResultList();
        for (Tbldepartment tbldepartment : dept) {
            availableIds.add(tbldepartment.getDepartmentID());
        }
        return availableIds;
    }

    public void setAvailableIds(Collection<Integer> availableIds) {
        this.availableIds = availableIds;
    }
    
    
}
