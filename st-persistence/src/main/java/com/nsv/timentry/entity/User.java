//: com.nsv.timentry.entity: User.java
package com.nsv.timentry.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Entity class mapping to table 'USERS'
 * 
 * @version 1.0.0 $ 2016-03-24 14:46 $
 */
@Entity
@Table( name = "USERS" )
public final class User implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer id;
    private String  email;
    private String  password;
    
    private short   empId;
    private short   roleId;
    private boolean isRemoved;
    
    private short   officeId;
    private short   version;
    
    
    // ------------------------------------------------------------------------
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Integer getId() {
        return this.id;
    }
    
    public void setId( Integer id ) {
        this.id = id;
    }

    @Column( name = "EMAIL", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getEmail() {
        return this.email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    @Column( name = "PASSWORD", nullable = false, length = 41 )
    @NotNull
    @Size( min = 1, max = 41 )
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password ) {
        this.password = password;
    }
    
    @Column( name = "EMP_ID", nullable = false )
    @NotNull
    public short getEmpId() {
        return this.empId;
    }

    public void setEmpId( short empId ) {
        this.empId = empId;
    }

    @Column( name = "ROLE_ID", nullable = false )
    @NotNull
    public short getRoleId() {
        return this.roleId;
    }

    public void setRoleId( short roleId ) {
        this.roleId = roleId;
    }

    @Column( name = "IS_REMOVED", nullable = false )
    @NotNull
    public boolean isRemoved() {
        return this.isRemoved;
    }

    public void setRemoved( boolean isRemoved ) {
        this.isRemoved = isRemoved;
    }

    @Column( name = "OFFICE_ID", nullable = false )
    @NotNull
    public short getOfficeId() {
        return this.officeId;
    }

    public void setOfficeId( short officeId ) {
        this.officeId = officeId;
    }

    @Column( name = "VERSION", nullable = false )
    @NotNull
    @Version
    public short getVersion() {
        return this.version;
    }
    
    public void setVersion( short version ) {
        this.version = version;
    }

    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.User[ id=" + id + " ]";
    }
    
    
} //:~
