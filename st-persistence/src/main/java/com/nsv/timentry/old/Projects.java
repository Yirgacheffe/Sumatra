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
@Table(name = "projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p"),
    @NamedQuery(name = "Projects.findById", query = "SELECT p FROM Projects p WHERE p.id = :id"),
    @NamedQuery(name = "Projects.findByProjNum", query = "SELECT p FROM Projects p WHERE p.projNum = :projNum"),
    @NamedQuery(name = "Projects.findByName", query = "SELECT p FROM Projects p WHERE p.name = :name"),
    @NamedQuery(name = "Projects.findByStartDate", query = "SELECT p FROM Projects p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Projects.findByCloseDate", query = "SELECT p FROM Projects p WHERE p.closeDate = :closeDate"),
    @NamedQuery(name = "Projects.findByIsProj", query = "SELECT p FROM Projects p WHERE p.isProj = :isProj"),
    @NamedQuery(name = "Projects.findByBudget", query = "SELECT p FROM Projects p WHERE p.budget = :budget"),
    @NamedQuery(name = "Projects.findByStatus", query = "SELECT p FROM Projects p WHERE p.status = :status"),
    @NamedQuery(name = "Projects.findByMemo", query = "SELECT p FROM Projects p WHERE p.memo = :memo"),
    @NamedQuery(name = "Projects.findByCreatorId", query = "SELECT p FROM Projects p WHERE p.creatorId = :creatorId"),
    @NamedQuery(name = "Projects.findByLastUpdatedBy", query = "SELECT p FROM Projects p WHERE p.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "Projects.findByTsCreated", query = "SELECT p FROM Projects p WHERE p.tsCreated = :tsCreated"),
    @NamedQuery(name = "Projects.findByTsUpdated", query = "SELECT p FROM Projects p WHERE p.tsUpdated = :tsUpdated"),
    @NamedQuery(name = "Projects.findByVersion", query = "SELECT p FROM Projects p WHERE p.version = :version")})
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROJ_NUM")
    private String projNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "CLOSE_DATE")
    @Temporal(TemporalType.DATE)
    private Date closeDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_PROJ")
    private boolean isProj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUDGET")
    private int budget;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STATUS")
    private String status;
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

    public Projects() {
    }

    public Projects(Integer id) {
        this.id = id;
    }

    public Projects(Integer id, String projNum, String name, Date startDate, boolean isProj, int budget, String status, String memo, int creatorId, int lastUpdatedBy, Date tsCreated, Date tsUpdated, short version) {
        this.id = id;
        this.projNum = projNum;
        this.name = name;
        this.startDate = startDate;
        this.isProj = isProj;
        this.budget = budget;
        this.status = status;
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

    public String getProjNum() {
        return projNum;
    }

    public void setProjNum(String projNum) {
        this.projNum = projNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean getIsProj() {
        return isProj;
    }

    public void setIsProj(boolean isProj) {
        this.isProj = isProj;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Projects[ id=" + id + " ]";
    }
    
}
