//: com.nsv.timentry.entity: ProjectRole.java
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
 * Entity class mapping to table 'PROJ_ROLES'
 * 
 * @version 1.0.0 $ 2016-03-24 11:29 $
 */
@Entity
@Table( name = "PROJ_ROLES" )
public final class ProjectRole implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Short   id;
    private String  abbr;
    private String  name;
    
    private boolean removed;
    private String  memo;
    private short   version;
    
    
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

    @Column( name = "ABBR", nullable = false, length = 4 )
    @NotNull
    @Size( min = 1, max = 4 )
    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr( String abbr ) {
        this.abbr = abbr;
    }
    
    @Column( name = "NAME", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }
    
    @Column( name = "IS_REMOVED", nullable = false )
    @NotNull
    public boolean isRemoved() {
        return this.removed;
    }

    public void setRemoved( boolean removed ) {
        this.removed = removed;
    }
    
    @Column( name = "MEMO", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getMemo() {
        return this.memo;
    }

    public void setMemo( String memo ) {
        this.memo = memo;
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
        return "com.nsv.timentry.persistence.ProjectRole[ id=" + id + " ]";
    }
    
    
} //:~
