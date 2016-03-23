/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsv.timentry.entity;

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
@Table(name = "day_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DayLogs.findAll", query = "SELECT d FROM DayLogs_1 d"),
    @NamedQuery(name = "DayLogs.findById", query = "SELECT d FROM DayLogs_1 d WHERE d.id = :id"),
    @NamedQuery(name = "DayLogs.findByWeekLog", query = "SELECT d FROM DayLogs_1 d WHERE d.weekLog = :weekLog"),
    @NamedQuery(name = "DayLogs.findByWorkDay", query = "SELECT d FROM DayLogs_1 d WHERE d.workDay = :workDay"),
    @NamedQuery(name = "DayLogs.findByEmpId", query = "SELECT d FROM DayLogs_1 d WHERE d.empId = :empId"),
    @NamedQuery(name = "DayLogs.findByStatus", query = "SELECT d FROM DayLogs_1 d WHERE d.status = :status"),
    @NamedQuery(name = "DayLogs.findByHours", query = "SELECT d FROM DayLogs_1 d WHERE d.hours = :hours"),
    @NamedQuery(name = "DayLogs.findByMeal", query = "SELECT d FROM DayLogs_1 d WHERE d.meal = :meal"),
    @NamedQuery(name = "DayLogs.findByVersion", query = "SELECT d FROM DayLogs_1 d WHERE d.version = :version")})
public class DayLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEEK_LOG")
    private int weekLog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WORK_DAY")
    @Temporal(TemporalType.DATE)
    private Date workDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_ID")
    private short empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOURS")
    private short hours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEAL")
    private short meal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private short version;

    public DayLogs() {
    }

    public DayLogs(Integer id) {
        this.id = id;
    }

    public DayLogs(Integer id, int weekLog, Date workDay, short empId, String status, short hours, short meal, short version) {
        this.id = id;
        this.weekLog = weekLog;
        this.workDay = workDay;
        this.empId = empId;
        this.status = status;
        this.hours = hours;
        this.meal = meal;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWeekLog() {
        return weekLog;
    }

    public void setWeekLog(int weekLog) {
        this.weekLog = weekLog;
    }

    public Date getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
    }

    public short getEmpId() {
        return empId;
    }

    public void setEmpId(short empId) {
        this.empId = empId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public short getHours() {
        return hours;
    }

    public void setHours(short hours) {
        this.hours = hours;
    }

    public short getMeal() {
        return meal;
    }

    public void setMeal(short meal) {
        this.meal = meal;
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
        if (!(object instanceof DayLogs)) {
            return false;
        }
        DayLogs other = (DayLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.DayLogs_1[ id=" + id + " ]";
    }
    
}
