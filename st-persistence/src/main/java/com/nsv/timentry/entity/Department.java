//: com.nsv.timentry.entity: Department.java
package com.nsv.timentry.entity;

import java.util.Collection;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;


/**
 * Entity class mapping to table 'DEPARTMENTS'
 * 
 * @version 1.0.0 $ 2016-03-24 09:33 $
 */
@Entity
@Table( name = "DEPARTMENTS" )
public final class Department implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    private Short  id;
    private String name;
    private String memo;
    
    private Collection<Employee> employees;
    
    
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
    
    @Column( name = "NAME", nullable = false, length = 100 )
    @NotNull
    @Size( min = 1, max = 100 )
    public String getName() {
        return this.name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    
    @Basic( fetch = LAZY )
    @Column( name ="MEMO", length = 100 )
    @Size( max = 100 )
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo( String memo ) {
        this.memo = memo;
    }
    
    @OneToMany( mappedBy = "dept" )
    public Collection<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees( Collection<Employee> employees ) {
        this.employees = employees;
    }
    
    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Department[ id=" + id + " ]";
    }

    
} //:~
