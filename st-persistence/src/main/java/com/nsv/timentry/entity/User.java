//: com.nsv.timentry.entity: User.java
package com.nsv.timentry.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Entity class mapping to table 'USERS'
 * 
 * @version 1.0.0 $ 2016-03-25 14:46 $
 */
@Entity
@Table( name = "USERS" )
public final class User implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer  id;
    private String   email;
    private String   password;
    
    private boolean  isRemoved;
    private short    version;
    private Role     role;
    private Office   office;
    private Employee employee;
    
    
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

    @Column( name = "IS_REMOVED", nullable = false )
    @NotNull
    public boolean isRemoved() {
        return this.isRemoved;
    }

    public void setRemoved( boolean isRemoved ) {
        this.isRemoved = isRemoved;
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
    
    @OneToOne
    @JoinColumn( name = "EMP_ID",    nullable = false )
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee( Employee employee ) {
        this.employee = employee;
    }
    
    @ManyToOne
    @JoinColumn( name = "ROLE_ID",   nullable = false )
    public Role getRole() {
        return this.role;
    }

    public void setRole( Role role ) {
        this.role = role;
    }
    
    @ManyToOne
    @JoinColumn( name = "OFFICE_ID", nullable = false )
    public Office getOffice() {
        return this.office;
    }

    public void setOffice( Office office ) {
        this.office = office;
    }
    
    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.User[ id=" + id + " ]";
    }
    
    
} //:~
