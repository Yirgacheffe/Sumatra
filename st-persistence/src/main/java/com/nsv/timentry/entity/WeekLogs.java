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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author woodpecker
 */
@Entity
@Table(name = "week_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WeekLogs.findAll", query = "SELECT w FROM WeekLogs w"),
    @NamedQuery(name = "WeekLogs.findById", query = "SELECT w FROM WeekLogs w WHERE w.id = :id"),
    @NamedQuery(name = "WeekLogs.findByYear", query = "SELECT w FROM WeekLogs w WHERE w.year = :year"),
    @NamedQuery(name = "WeekLogs.findByWeek", query = "SELECT w FROM WeekLogs w WHERE w.week = :week"),
    @NamedQuery(name = "WeekLogs.findByEmpId", query = "SELECT w FROM WeekLogs w WHERE w.empId = :empId"),
    @NamedQuery(name = "WeekLogs.findByStatus", query = "SELECT w FROM WeekLogs w WHERE w.status = :status"),
    @NamedQuery(name = "WeekLogs.findByVersion", query = "SELECT w FROM WeekLogs w WHERE w.version = :version")})
public class WeekLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YEAR")
    private short year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEEK")
    private short week;
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
    @Column(name = "VERSION")
    private short version;

    public WeekLogs() {
    }

    public WeekLogs(Integer id) {
        this.id = id;
    }

    public WeekLogs(Integer id, short year, short week, short empId, String status, short version) {
        this.id = id;
        this.year = year;
        this.week = week;
        this.empId = empId;
        this.status = status;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getWeek() {
        return week;
    }

    public void setWeek(short week) {
        this.week = week;
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
        if (!(object instanceof WeekLogs)) {
            return false;
        }
        WeekLogs other = (WeekLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.WeekLogs[ id=" + id + " ]";
    }
    
}
