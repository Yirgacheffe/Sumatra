/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsv.timentry.old;

import com.nsv.timentry.entity.*;
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
 * @author woodpecker
 */
@Entity
@Table(name = "offices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offices.findAll", query = "SELECT o FROM Offices o"),
    @NamedQuery(name = "Offices.findById", query = "SELECT o FROM Offices o WHERE o.id = :id"),
    @NamedQuery(name = "Offices.findByAddress", query = "SELECT o FROM Offices o WHERE o.address = :address"),
    @NamedQuery(name = "Offices.findByName", query = "SELECT o FROM Offices o WHERE o.name = :name"),
    @NamedQuery(name = "Offices.findByWorkingHours", query = "SELECT o FROM Offices o WHERE o.workingHours = :workingHours"),
    @NamedQuery(name = "Offices.findByIsInuse", query = "SELECT o FROM Offices o WHERE o.isInuse = :isInuse"),
    @NamedQuery(name = "Offices.findByMemo", query = "SELECT o FROM Offices o WHERE o.memo = :memo")})
public class Offices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WORKING_HOURS")
    private short workingHours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_INUSE")
    private boolean isInuse;
    @Size(max = 100)
    @Column(name = "MEMO")
    private String memo;

    public Offices() {
    }

    public Offices(Short id) {
        this.id = id;
    }

    public Offices(Short id, String address, String name, short workingHours, boolean isInuse) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.workingHours = workingHours;
        this.isInuse = isInuse;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(short workingHours) {
        this.workingHours = workingHours;
    }

    public boolean getIsInuse() {
        return isInuse;
    }

    public void setIsInuse(boolean isInuse) {
        this.isInuse = isInuse;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offices)) {
            return false;
        }
        Offices other = (Offices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Offices[ id=" + id + " ]";
    }
    
}
