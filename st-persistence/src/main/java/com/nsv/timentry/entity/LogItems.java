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
@Table(name = "log_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogItems.findAll", query = "SELECT l FROM LogItems l"),
    @NamedQuery(name = "LogItems.findById", query = "SELECT l FROM LogItems l WHERE l.id = :id"),
    @NamedQuery(name = "LogItems.findByType", query = "SELECT l FROM LogItems l WHERE l.type = :type"),
    @NamedQuery(name = "LogItems.findByContent", query = "SELECT l FROM LogItems l WHERE l.content = :content"),
    @NamedQuery(name = "LogItems.findByHours", query = "SELECT l FROM LogItems l WHERE l.hours = :hours"),
    @NamedQuery(name = "LogItems.findByStartOn", query = "SELECT l FROM LogItems l WHERE l.startOn = :startOn"),
    @NamedQuery(name = "LogItems.findByCloseOn", query = "SELECT l FROM LogItems l WHERE l.closeOn = :closeOn"),
    @NamedQuery(name = "LogItems.findByPlace", query = "SELECT l FROM LogItems l WHERE l.place = :place")})
public class LogItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 2)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "CONTENT")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOURS")
    private short hours;
    @Column(name = "START_ON")
    @Temporal(TemporalType.TIME)
    private Date startOn;
    @Column(name = "CLOSE_ON")
    @Temporal(TemporalType.TIME)
    private Date closeOn;
    @Column(name = "PLACE")
    private Character place;

    public LogItems() {
    }

    public LogItems(Integer id) {
        this.id = id;
    }

    public LogItems(Integer id, String content, short hours) {
        this.id = id;
        this.content = content;
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getHours() {
        return hours;
    }

    public void setHours(short hours) {
        this.hours = hours;
    }

    public Date getStartOn() {
        return startOn;
    }

    public void setStartOn(Date startOn) {
        this.startOn = startOn;
    }

    public Date getCloseOn() {
        return closeOn;
    }

    public void setCloseOn(Date closeOn) {
        this.closeOn = closeOn;
    }

    public Character getPlace() {
        return place;
    }

    public void setPlace(Character place) {
        this.place = place;
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
        if (!(object instanceof LogItems)) {
            return false;
        }
        LogItems other = (LogItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.LogItems[ id=" + id + " ]";
    }
    
}
