//: com.nsv.timentry.entity: Employee.java
package com.nsv.timentry.entity;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;


/**
 * Entity class mapping to table 'EMPLOYEE'
 * 
 * @version 1.0.0 $ 2016-03-24 11:58 $
 */
@Entity
@Table( name = "EMPLOYEE" )
public class Employee implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    private Short   id;
    private String  name;
    private Gender  gender;
    private String  email;
    private Date    onBoardDate;
    private Date    probationEnd;
    private Date    lastWorkingDay;
    private Short   deptId;
    private Short   diplomaId;
    
    private String  graduationYr;
    private String  college;
    private String  major;
    private String  position;
    private String  nation;
    
    private boolean isMarried;
    
    private String  politicalType;
    private String  residence;
    private String  idcardNum;
    private String  archiveFile;
    private String  memo;
    private Short   version;


    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Short getId() {
        return this.id;
    }
    
    public void setId( Short id ) {
        this.id = id;
    }
    
    
    @Column( name = "NAME", nullable = false )
    public String getName() {
        return this.name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    
    
    @Column( name = "GENDER", nullable = false )
    public Gender getGender() {
        return this.gender;
    }
    
    public void setGender( Gender gender ) {
        this.gender = gender;
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
    
    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Employee[ id=" + id + " ]";
    }
    
} //:~
