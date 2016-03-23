/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsv.timentry.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author woodpecker
 */
@Embeddable
public class EmpHrRolesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_ID")
    private short empId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HR_ROLE_ID")
    private short hrRoleId;

    public EmpHrRolesPK() {
    }

    public EmpHrRolesPK(short empId, short hrRoleId) {
        this.empId = empId;
        this.hrRoleId = hrRoleId;
    }

    public short getEmpId() {
        return empId;
    }

    public void setEmpId(short empId) {
        this.empId = empId;
    }

    public short getHrRoleId() {
        return hrRoleId;
    }

    public void setHrRoleId(short hrRoleId) {
        this.hrRoleId = hrRoleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empId;
        hash += (int) hrRoleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpHrRolesPK)) {
            return false;
        }
        EmpHrRolesPK other = (EmpHrRolesPK) object;
        if (this.empId != other.empId) {
            return false;
        }
        if (this.hrRoleId != other.hrRoleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.EmpHrRolesPK[ empId=" + empId + ", hrRoleId=" + hrRoleId + " ]";
    }
    
}
