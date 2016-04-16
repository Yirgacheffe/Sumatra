//: com.nsv.timentry.entity: Phase.java
package com.nsv.timentry.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;


/**
 * Entity class mapping to table 'PHASES'
 * 
 * @version 1.0.0 $ 2016-03-24 10:32 $
 */
@Entity
@Table( name = "PHASES" )
public final class Phase implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Short  id;
    private String name;
    private String memo;
    
    
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

    @Column( name = "NAME", nullable = false, length = 30 )
    @NotNull
    @Size( min = 1, max = 30 )
    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }
    
    @Basic( fetch = LAZY )
    @Column( name = "MEMO", nullable = true )
    @Size(max = 30)
    public String getMemo() {
        return this.memo;
    }

    public void setMemo( String memo ) {
        this.memo = memo;
    }

    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Phase[ id=" + id + " ]";
    }
    
    
} //:~
