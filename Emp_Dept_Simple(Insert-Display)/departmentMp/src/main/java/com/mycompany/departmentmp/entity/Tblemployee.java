/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.departmentmp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "tblemployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblemployee.findAll", query = "SELECT t FROM Tblemployee t"),
    @NamedQuery(name = "Tblemployee.findByEmployeeID", query = "SELECT t FROM Tblemployee t WHERE t.employeeID = :employeeID"),
    @NamedQuery(name = "Tblemployee.findByEmployeeName", query = "SELECT t FROM Tblemployee t WHERE t.employeeName = :employeeName"),
    @NamedQuery(name = "Tblemployee.findByGender", query = "SELECT t FROM Tblemployee t WHERE t.gender = :gender"),
    @NamedQuery(name = "Tblemployee.findBySalary", query = "SELECT t FROM Tblemployee t WHERE t.salary = :salary"),
    @NamedQuery(name = "Tblemployee.findByJoiningDate", query = "SELECT t FROM Tblemployee t WHERE t.joiningDate = :joiningDate")})
public class Tblemployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employeeID")
    private Integer employeeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "employeeName")
    private String employeeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private int salary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "joiningDate")
    private String joiningDate;
    @JoinColumn(name = "departmentID", referencedColumnName = "departmentID")
    @ManyToOne(optional = false)
    private Tbldepartment departmentID;

    public Tblemployee() {
    }

    public Tblemployee(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Tblemployee(Integer employeeID, String employeeName, String gender, int salary, String joiningDate) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.gender = gender;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Tbldepartment getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Tbldepartment departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblemployee)) {
            return false;
        }
        Tblemployee other = (Tblemployee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.departmentmp.entity.Tblemployee[ employeeID=" + employeeID + " ]";
    }
    
}
