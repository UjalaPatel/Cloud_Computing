package com.mycompany.employeemp.entity;

import com.mycompany.employeemp.entity.Tblemployee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-05T22:16:18")
@StaticMetamodel(Tbldepartment.class)
public class Tbldepartment_ { 

    public static volatile SingularAttribute<Tbldepartment, String> departmentName;
    public static volatile CollectionAttribute<Tbldepartment, Tblemployee> tblemployeeCollection;
    public static volatile SingularAttribute<Tbldepartment, Integer> departmentID;

}