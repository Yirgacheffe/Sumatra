/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsv.timentry.old;

import com.nsv.timentry.entity.*;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.nsv.timentry.keys.EmpHrRolePK;


/**
 *
 * @author woodpecker
 */
@Entity
@Table(name = "emp_hr_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpHrRoles.findAll", query = "SELECT e FROM EmpHrRoles e"),
    @NamedQuery(name = "EmpHrRoles.findByEmpId", query = "SELECT e FROM EmpHrRoles e WHERE e.empHrRolesPK.empId = :empId"),
    @NamedQuery(name = "EmpHrRoles.findByHrRoleId", query = "SELECT e FROM EmpHrRoles e WHERE e.empHrRolesPK.hrRoleId = :hrRoleId")})
public class EmpHrRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EmpHrRolePK empHrRolesPK;

    public EmpHrRoles() {
    }

    public EmpHrRoles(EmpHrRolePK empHrRolesPK) {
        this.empHrRolesPK = empHrRolesPK;
    }

    public EmpHrRoles(short empId, short hrRoleId) {
        this.empHrRolesPK = new EmpHrRolePK(empId, hrRoleId);
    }

    public EmpHrRolePK getEmpHrRolesPK() {
        return empHrRolesPK;
    }

    public void setEmpHrRolesPK(EmpHrRolePK empHrRolesPK) {
        this.empHrRolesPK = empHrRolesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empHrRolesPK != null ? empHrRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpHrRoles)) {
            return false;
        }
        EmpHrRoles other = (EmpHrRoles) object;
        if ((this.empHrRolesPK == null && other.empHrRolesPK != null) || (this.empHrRolesPK != null && !this.empHrRolesPK.equals(other.empHrRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.EmpHrRoles[ empHrRolesPK=" + empHrRolesPK + " ]";
    }
    
}
