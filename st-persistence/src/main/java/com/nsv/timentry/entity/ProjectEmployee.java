//: com.nsv.timentry.entity: ProjectEmployee.java
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

import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Entity class mapping to table 'PROJ_EMPS'
 * 
 * @version 1.0.0 $ 2016-03-24 10:54 $
 */
@Entity
@Table( name = "PROJ_EMPS" )
public final class ProjectEmployee implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer id;
    private int     projId;
    private int     taskId;
    
    private short   empId;
    private short   roleId;
    
    private Date    joinDate;
    private Date    leftDate;
    
    
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

    @Column( name = "PROJ_ID", nullable = false )
    @NotNull
    public int getProjId() {
        return this.projId;
    }

    public void setProjId( int projId ) {
        this.projId = projId;
    }

    @Column( name = "TASK_ID", nullable = false )
    @NotNull
    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId( int taskId ) {
        this.taskId = taskId;
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
    
    @Column( name = "JOIN_DATE", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getJoinDate() {
        return this.joinDate;
    }

    public void setJoinDate( Date joinDate ) {
        this.joinDate = joinDate;
    }
    
    @Column( name = "LEFT_DATE", nullable = true )
    @Temporal( TemporalType.DATE )

    public Date getLeftDate() {
        return this.leftDate;
    }

    public void setLeftDate( Date leftDate ) {
        this.leftDate = leftDate;
    }

    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.ProjectEmployee[ id=" + id + " ]";
    }
    
    
} //:~
