/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customermp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tblcustomer")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcustomer.findAll", query = "SELECT t FROM Tblcustomer t"),
    @NamedQuery(name = "Tblcustomer.findByCustomerID", query = "SELECT t FROM Tblcustomer t WHERE t.customerID = :customerID"),
    @NamedQuery(name = "Tblcustomer.findByEmail", query = "SELECT t FROM Tblcustomer t WHERE t.email = :email"),
    @NamedQuery(name = "Tblcustomer.findByName", query = "SELECT t FROM Tblcustomer t WHERE t.name = :name"),
    @NamedQuery(name = "Tblcustomer.findByRating", query = "SELECT t FROM Tblcustomer t WHERE t.rating = :rating"),
    @NamedQuery(name = "Tblcustomer.findByAddress", query = "SELECT t FROM Tblcustomer t WHERE t.address = :address"),
    @NamedQuery(name = "Tblcustomer.findByPhoneNo", query = "SELECT t FROM Tblcustomer t WHERE t.phoneNo = :phoneNo")})
public class Tblcustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customerID")
    private Integer customerID;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "phoneNo")
    private String phoneNo;

    public Tblcustomer() {
    }

    public Tblcustomer(Integer customerID) {
        this.customerID = customerID;
    }

    public Tblcustomer(Integer customerID, String email, String name, int rating, String address, String phoneNo) {
        this.customerID = customerID;
        this.email = email;
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcustomer)) {
            return false;
        }
        Tblcustomer other = (Tblcustomer) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.customermp.entity.Tblcustomer[ customerID=" + customerID + " ]";
    }
    
}
