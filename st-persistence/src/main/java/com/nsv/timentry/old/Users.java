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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByEmpId", query = "SELECT u FROM Users u WHERE u.empId = :empId"),
    @NamedQuery(name = "Users.findByRoleId", query = "SELECT u FROM Users u WHERE u.roleId = :roleId"),
    @NamedQuery(name = "Users.findByIsRemoved", query = "SELECT u FROM Users u WHERE u.isRemoved = :isRemoved"),
    @NamedQuery(name = "Users.findByOfficeId", query = "SELECT u FROM Users u WHERE u.officeId = :officeId"),
    @NamedQuery(name = "Users.findByVersion", query = "SELECT u FROM Users u WHERE u.version = :version")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 41)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMP_ID")
    private Short empId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ID")
    private short roleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_REMOVED")
    private boolean isRemoved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OFFICE_ID")
    private short officeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private short version;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String email, String password, short roleId, boolean isRemoved, short officeId, short version) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.isRemoved = isRemoved;
        this.officeId = officeId;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getEmpId() {
        return empId;
    }

    public void setEmpId(Short empId) {
        this.empId = empId;
    }

    public short getRoleId() {
        return roleId;
    }

    public void setRoleId(short roleId) {
        this.roleId = roleId;
    }

    public boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public short getOfficeId() {
        return officeId;
    }

    public void setOfficeId(short officeId) {
        this.officeId = officeId;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Users[ id=" + id + " ]";
    }
    
}
