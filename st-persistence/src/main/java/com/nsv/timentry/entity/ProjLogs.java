/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsv.timentry.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author woodpecker
 */
@Entity
@Table(name = "proj_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjLogs.findAll", query = "SELECT p FROM ProjLogs p"),
    @NamedQuery(name = "ProjLogs.findById", query = "SELECT p FROM ProjLogs p WHERE p.id = :id"),
    @NamedQuery(name = "ProjLogs.findByDayLog", query = "SELECT p FROM ProjLogs p WHERE p.dayLog = :dayLog"),
    @NamedQuery(name = "ProjLogs.findByItemId", query = "SELECT p FROM ProjLogs p WHERE p.itemId = :itemId"),
    @NamedQuery(name = "ProjLogs.findByProjId", query = "SELECT p FROM ProjLogs p WHERE p.projId = :projId"),
    @NamedQuery(name = "ProjLogs.findByTaskId", query = "SELECT p FROM ProjLogs p WHERE p.taskId = :taskId")})
public class ProjLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAY_LOG")
    private int dayLog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_ID")
    private int itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJ_ID")
    private int projId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TASK_ID")
    private int taskId;

    public ProjLogs() {
    }

    public ProjLogs(Integer id) {
        this.id = id;
    }

    public ProjLogs(Integer id, int dayLog, int itemId, int projId, int taskId) {
        this.id = id;
        this.dayLog = dayLog;
        this.itemId = itemId;
        this.projId = projId;
        this.taskId = taskId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDayLog() {
        return dayLog;
    }

    public void setDayLog(int dayLog) {
        this.dayLog = dayLog;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjLogs)) {
            return false;
        }
        ProjLogs other = (ProjLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.ProjLogs[ id=" + id + " ]";
    }
    
}
