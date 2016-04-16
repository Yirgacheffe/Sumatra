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
@Table(name = "proj_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjRoles.findAll", query = "SELECT p FROM ProjRoles p"),
    @NamedQuery(name = "ProjRoles.findById", query = "SELECT p FROM ProjRoles p WHERE p.id = :id"),
    @NamedQuery(name = "ProjRoles.findByAcronym", query = "SELECT p FROM ProjRoles p WHERE p.acronym = :acronym"),
    @NamedQuery(name = "ProjRoles.findByName", query = "SELECT p FROM ProjRoles p WHERE p.name = :name"),
    @NamedQuery(name = "ProjRoles.findByMemo", query = "SELECT p FROM ProjRoles p WHERE p.memo = :memo"),
    @NamedQuery(name = "ProjRoles.findByIsRemoved", query = "SELECT p FROM ProjRoles p WHERE p.isRemoved = :isRemoved"),
    @NamedQuery(name = "ProjRoles.findByVersion", query = "SELECT p FROM ProjRoles p WHERE p.version = :version")})
public class ProjRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ACRONYM")
    private String acronym;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MEMO")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_REMOVED")
    private boolean isRemoved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private short version;

    public ProjRoles() {
    }

    public ProjRoles(Short id) {
        this.id = id;
    }

    public ProjRoles(Short id, String acronym, String name, String memo, boolean isRemoved, short version) {
        this.id = id;
        this.acronym = acronym;
        this.name = name;
        this.memo = memo;
        this.isRemoved = isRemoved;
        this.version = version;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public short getVersion() {
        return version;
    }

    public void setVersion(short version) {
        this.version = version;
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
        if (!(object instanceof ProjRoles)) {
            return false;
        }
        ProjRoles other = (ProjRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.ProjRoles[ id=" + id + " ]";
    }
    
}
