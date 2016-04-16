/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsv.timentry.old;

import com.nsv.timentry.entity.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author woodpecker
 */
@Entity
@Table(name = "proj_emps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjEmps.findAll", query = "SELECT p FROM ProjEmps p"),
    @NamedQuery(name = "ProjEmps.findById", query = "SELECT p FROM ProjEmps p WHERE p.id = :id"),
    @NamedQuery(name = "ProjEmps.findByProjId", query = "SELECT p FROM ProjEmps p WHERE p.projId = :projId"),
    @NamedQuery(name = "ProjEmps.findByTaskId", query = "SELECT p FROM ProjEmps p WHERE p.taskId = :taskId"),
    @NamedQuery(name = "ProjEmps.findByEmpId", query = "SELECT p FROM ProjEmps p WHERE p.empId = :empId"),
    @NamedQuery(name = "ProjEmps.findByRoleId", query = "SELECT p FROM ProjEmps p WHERE p.roleId = :roleId"),
    @NamedQuery(name = "ProjEmps.findByJoinDate", query = "SELECT p FROM ProjEmps p WHERE p.joinDate = :joinDate"),
    @NamedQuery(name = "ProjEmps.findByLeftDate", query = "SELECT p FROM ProjEmps p WHERE p.leftDate = :leftDate")})
public class ProjEmps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJ_ID")
    private int projId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TASK_ID")
    private int taskId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_ID")
    private short empId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ID")
    private short roleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOIN_DATE")
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Column(name = "LEFT_DATE")
    @Temporal(TemporalType.DATE)
    private Date leftDate;

    public ProjEmps() {
    }

    public ProjEmps(Integer id) {
        this.id = id;
    }

    public ProjEmps(Integer id, int projId, int taskId, short empId, short roleId, Date joinDate) {
        this.id = id;
        this.projId = projId;
        this.taskId = taskId;
        this.empId = empId;
        this.roleId = roleId;
        this.joinDate = joinDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public short getEmpId() {
        return empId;
    }

    public void setEmpId(short empId) {
        this.empId = empId;
    }

    public short getRoleId() {
        return roleId;
    }

    public void setRoleId(short roleId) {
        this.roleId = roleId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getLeftDate() {
        return leftDate;
    }

    public void setLeftDate(Date leftDate) {
        this.leftDate = leftDate;
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
        if (!(object instanceof ProjEmps)) {
            return false;
        }
        ProjEmps other = (ProjEmps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.ProjEmps[ id=" + id + " ]";
    }
    
}
