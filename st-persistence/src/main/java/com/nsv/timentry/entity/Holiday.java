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
@Table(name = "holiday")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Holiday.findAll", query = "SELECT h FROM Holiday h"),
    @NamedQuery(name = "Holiday.findById", query = "SELECT h FROM Holiday h WHERE h.id = :id"),
    @NamedQuery(name = "Holiday.findByHoliDate", query = "SELECT h FROM Holiday h WHERE h.holiDate = :holiDate"),
    @NamedQuery(name = "Holiday.findByName", query = "SELECT h FROM Holiday h WHERE h.name = :name"),
    @NamedQuery(name = "Holiday.findByType", query = "SELECT h FROM Holiday h WHERE h.type = :type"),
    @NamedQuery(name = "Holiday.findByWeek", query = "SELECT h FROM Holiday h WHERE h.week = :week"),
    @NamedQuery(name = "Holiday.findByMemo", query = "SELECT h FROM Holiday h WHERE h.memo = :memo"),
    @NamedQuery(name = "Holiday.findByVersion", query = "SELECT h FROM Holiday h WHERE h.version = :version")})
public class Holiday implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOLI_DATE")
    @Temporal(TemporalType.DATE)
    private Date holiDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEEK")
    private short week;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEMO")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private short version;

    public Holiday() {
    }

    public Holiday(Integer id) {
        this.id = id;
    }

    public Holiday(Integer id, Date holiDate, String name, String type, short week, String memo, short version) {
        this.id = id;
        this.holiDate = holiDate;
        this.name = name;
        this.type = type;
        this.week = week;
        this.memo = memo;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHoliDate() {
        return holiDate;
    }

    public void setHoliDate(Date holiDate) {
        this.holiDate = holiDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public short getWeek() {
        return week;
    }

    public void setWeek(short week) {
        this.week = week;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
        if (!(object instanceof Holiday)) {
            return false;
        }
        Holiday other = (Holiday) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Holiday[ id=" + id + " ]";
    }
    
}
