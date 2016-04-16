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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author woodpecker
 */
@Entity
@Table(name = "proj_tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjTasks.findAll", query = "SELECT p FROM ProjTasks p"),
    @NamedQuery(name = "ProjTasks.findById", query = "SELECT p FROM ProjTasks p WHERE p.id = :id"),
    @NamedQuery(name = "ProjTasks.findByProjId", query = "SELECT p FROM ProjTasks p WHERE p.projId = :projId"),
    @NamedQuery(name = "ProjTasks.findByName", query = "SELECT p FROM ProjTasks p WHERE p.name = :name"),
    @NamedQuery(name = "ProjTasks.findByIsExtenal", query = "SELECT p FROM ProjTasks p WHERE p.isExtenal = :isExtenal"),
    @NamedQuery(name = "ProjTasks.findByStartDate", query = "SELECT p FROM ProjTasks p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "ProjTasks.findByCloseDate", query = "SELECT p FROM ProjTasks p WHERE p.closeDate = :closeDate"),
    @NamedQuery(name = "ProjTasks.findByEstimation", query = "SELECT p FROM ProjTasks p WHERE p.estimation = :estimation"),
    @NamedQuery(name = "ProjTasks.findByPhaseId", query = "SELECT p FROM ProjTasks p WHERE p.phaseId = :phaseId"),
    @NamedQuery(name = "ProjTasks.findByMemo", query = "SELECT p FROM ProjTasks p WHERE p.memo = :memo"),
    @NamedQuery(name = "ProjTasks.findByCreatorId", query = "SELECT p FROM ProjTasks p WHERE p.creatorId = :creatorId"),
    @NamedQuery(name = "ProjTasks.findByLastUpdatedBy", query = "SELECT p FROM ProjTasks p WHERE p.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "ProjTasks.findByTsCreated", query = "SELECT p FROM ProjTasks p WHERE p.tsCreated = :tsCreated"),
    @NamedQuery(name = "ProjTasks.findByTsUpdated", query = "SELECT p FROM ProjTasks p WHERE p.tsUpdated = :tsUpdated"),
    @NamedQuery(name = "ProjTasks.findByVersion", query = "SELECT p FROM ProjTasks p WHERE p.version = :version")})
public class ProjTasks implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_EXTENAL")
    private boolean isExtenal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLOSE_DATE")
    @Temporal(TemporalType.DATE)
    private Date closeDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTIMATION")
    private int estimation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PHASE_ID")
    private short phaseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "MEMO")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATOR_ID")
    private int creatorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_UPDATED_BY")
    private int lastUpdatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TS_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsCreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TS_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsUpdated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private short version;

    public ProjTasks() {
    }

    public ProjTasks(Integer id) {
        this.id = id;
    }

    public ProjTasks(Integer id, int projId, String name, boolean isExtenal, Date startDate, Date closeDate, int estimation, short phaseId, String memo, int creatorId, int lastUpdatedBy, Date tsCreated, Date tsUpdated, short version) {
        this.id = id;
        this.projId = projId;
        this.name = name;
        this.isExtenal = isExtenal;
        this.startDate = startDate;
        this.closeDate = closeDate;
        this.estimation = estimation;
        this.phaseId = phaseId;
        this.memo = memo;
        this.creatorId = creatorId;
        this.lastUpdatedBy = lastUpdatedBy;
        this.tsCreated = tsCreated;
        this.tsUpdated = tsUpdated;
        this.version = version;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsExtenal() {
        return isExtenal;
    }

    public void setIsExtenal(boolean isExtenal) {
        this.isExtenal = isExtenal;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public short getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(short phaseId) {
        this.phaseId = phaseId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getTsCreated() {
        return tsCreated;
    }

    public void setTsCreated(Date tsCreated) {
        this.tsCreated = tsCreated;
    }

    public Date getTsUpdated() {
        return tsUpdated;
    }

    public void setTsUpdated(Date tsUpdated) {
        this.tsUpdated = tsUpdated;
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
        if (!(object instanceof ProjTasks)) {
            return false;
        }
        ProjTasks other = (ProjTasks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.ProjTasks[ id=" + id + " ]";
    }
    
}
