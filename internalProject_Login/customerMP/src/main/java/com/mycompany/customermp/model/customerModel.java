/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customermp.model;

import com.mycompany.customermp.entity.Tblcustomer;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ASUS
 */

public class customerModel {
    EntityManager em;
    Collection<Tblcustomer> c;

    public customerModel() {
        em = Persistence.createEntityManagerFactory("customerPU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Tblcustomer> getC(String condition,int rating) {
        
        if("lessthan".equals(condition))
        {
            c = em.createNativeQuery("select * from Tblcustomer where rating <" + rating,Tblcustomer.class).getResultList();
        }
        if("greaterthan".equals(condition))
        {
            c = em.createNativeQuery("select * from Tblcustomer where rating >" + rating,Tblcustomer.class).getResultList();
        }
        if("lte".equals(condition))
        {
            c = em.createNativeQuery("select * from Tblcustomer where rating <=" + rating,Tblcustomer.class).getResultList();
        }
        if("gte".equals(condition))
        {
            c = em.createNativeQuery("select * from Tblcustomer where rating >=" + rating,Tblcustomer.class).getResultList();
        }
        if("equal".equals(condition))
        {
            c = em.createNativeQuery("select * from Tblcustomer where rating =" + rating,Tblcustomer.class).getResultList();
        }
        return c;
    }
    
}
