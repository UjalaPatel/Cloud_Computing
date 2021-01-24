/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeemp.model;

import com.mycompany.employeemp.entity.Tbldepartment;
import com.mycompany.employeemp.entity.Tblemployee;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

/**
 *
 * @author ASUS
 */
@Named
@ApplicationScoped
public class employeeModel {
    EntityManager em;
    Collection<Tblemployee> emp;

    public employeeModel() {
        em = Persistence.createEntityManagerFactory("employeePU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Object[]> getEmp(Collection<Integer> ids) {
        String allids = convertIntCollectionToString(ids);
        return em.createNativeQuery("select * from Tblemployee e,Tbldepartment d where d.departmentID in ("+ allids+")").getResultList();
    }

    public void setEmp(Collection<Tblemployee> emp) {
        this.emp = emp;
    }
    
    private String convertIntCollectionToString(Collection<Integer> ids)
    {
        String intString="";
        for(Integer i : ids)
        {
            intString += i.toString() +",";
        }
        return intString.substring(0, intString.length()-1);
    }
    
    @Transactional
    public void addEmp(String employeeName,String gender,int salary,String joiningDate,int departmentID)
    {
        em.getTransaction().begin();
        Tblemployee e = new Tblemployee();
        e.setEmployeeName(employeeName);
        e.setGender(gender);
        e.setSalary(salary);
        e.setJoiningDate(joiningDate);
        e.setDepartmentID(new Tbldepartment(departmentID));
        em.persist(e);
        em.getTransaction().commit();
    }
}
