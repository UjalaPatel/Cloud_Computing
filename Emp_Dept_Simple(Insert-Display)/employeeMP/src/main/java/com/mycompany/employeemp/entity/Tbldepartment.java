/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeemp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "tbldepartment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldepartment.findAll", query = "SELECT t FROM Tbldepartment t"),
    @NamedQuery(name = "Tbldepartment.findByDepartmentID", query = "SELECT t FROM Tbldepartment t WHERE t.departmentID = :departmentID"),
    @NamedQuery(name = "Tbldepartment.findByDepartmentName", query = "SELECT t FROM Tbldepartment t WHERE t.departmentName = :departmentName")})
public class Tbldepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "departmentID")
    private Integer departmentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "departmentName")
    private String departmentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentID")
    private Collection<Tblemployee> tblemployeeCollection;

    public Tbldepartment() {
    }

    public Tbldepartment(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Tbldepartment(Integer departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @XmlTransient
    public Collection<Tblemployee> getTblemployeeCollection() {
        return tblemployeeCollection;
    }

    public void setTblemployeeCollection(Collection<Tblemployee> tblemployeeCollection) {
        this.tblemployeeCollection = tblemployeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldepartment)) {
            return false;
        }
        Tbldepartment other = (Tbldepartment) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.employeemp.entity.Tbldepartment[ departmentID=" + departmentID + " ]";
    }
    
}
