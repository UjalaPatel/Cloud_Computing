package com.mycompany.employeemp.entity;

import com.mycompany.employeemp.entity.Tbldepartment;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-05T22:16:18")
@StaticMetamodel(Tblemployee.class)
public class Tblemployee_ { 

    public static volatile SingularAttribute<Tblemployee, String> employeeName;
    public static volatile SingularAttribute<Tblemployee, String> gender;
    public static volatile SingularAttribute<Tblemployee, Tbldepartment> departmentID;
    public static volatile SingularAttribute<Tblemployee, Integer> employeeID;
    public static volatile SingularAttribute<Tblemployee, String> joiningDate;
    public static volatile SingularAttribute<Tblemployee, Integer> salary;

}