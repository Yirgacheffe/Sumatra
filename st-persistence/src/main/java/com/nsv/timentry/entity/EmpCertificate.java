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
@Table(name = "emp_certificate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpCertificate.findAll", query = "SELECT e FROM EmpCertificate e"),
    @NamedQuery(name = "EmpCertificate.findById", query = "SELECT e FROM EmpCertificate e WHERE e.id = :id"),
    @NamedQuery(name = "EmpCertificate.findByEmpId", query = "SELECT e FROM EmpCertificate e WHERE e.empId = :empId"),
    @NamedQuery(name = "EmpCertificate.findByCertName", query = "SELECT e FROM EmpCertificate e WHERE e.certName = :certName"),
    @NamedQuery(name = "EmpCertificate.findByIssuer", query = "SELECT e FROM EmpCertificate e WHERE e.issuer = :issuer"),
    @NamedQuery(name = "EmpCertificate.findByIssueDate", query = "SELECT e FROM EmpCertificate e WHERE e.issueDate = :issueDate"),
    @NamedQuery(name = "EmpCertificate.findByExpireDate", query = "SELECT e FROM EmpCertificate e WHERE e.expireDate = :expireDate")})
public class EmpCertificate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_ID")
    private short empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CERT_NAME")
    private String certName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ISSUER")
    private String issuer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    public EmpCertificate() {
    }

    public EmpCertificate(Integer id) {
        this.id = id;
    }

    public EmpCertificate(Integer id, short empId, String certName, String issuer, Date issueDate) {
        this.id = id;
        this.empId = empId;
        this.certName = certName;
        this.issuer = issuer;
        this.issueDate = issueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getEmpId() {
        return empId;
    }

    public void setEmpId(short empId) {
        this.empId = empId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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
        if (!(object instanceof EmpCertificate)) {
            return false;
        }
        EmpCertificate other = (EmpCertificate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.EmpCertificate[ id=" + id + " ]";
    }
    
}
