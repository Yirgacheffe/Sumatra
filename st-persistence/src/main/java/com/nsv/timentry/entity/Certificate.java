//: com.nsv.timentry.entity: Certificate.java
package com.nsv.timentry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Entity class mapping to table 'CERTIFICATES'
 * 
 * @version 1.0.0 $ 2016-03-24 17:10 $
 */
@Entity
@Table( name = "CERTIFICATES" )
public final class Certificate implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    
    private Short  id;
    private String certName;
    private String issuer;
    
    private Date issueDate;
    private Date expireDate;
    
    private Employee employee;
    
    
    // ------------------------------------------------------------------------
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Short getId() {
        return this.id;
    }
    
    public void setId( Short id ) {
        this.id = id;
    }
    
    @Column( name = "CERT_NAME", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }
    
    @Column( name = "ISSUER", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer( String issuer ) {
        this.issuer = issuer;
    }

    @Column( name = "ISSUE_DATE", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate( Date issueDate ) {
        this.issueDate = issueDate;
    }

    @Column( name = "EXPIRE_DATE", nullable = true )
    @Temporal( TemporalType.DATE )
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate( Date expireDate ) {
        this.expireDate = expireDate;
    }
    
    @ManyToOne
    @JoinColumn( name = "EMP_ID", nullable = false )
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee( Employee employee ) {
        this.employee = employee;
    }
    
    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Certificate[ id=" + id + " ]";
    }
    
    
} //:~
