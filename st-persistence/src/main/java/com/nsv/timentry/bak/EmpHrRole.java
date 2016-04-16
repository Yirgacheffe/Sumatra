//: com.nsv.timentry.entity: EmpHrRole.java
package com.nsv.timentry.bak;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nsv.timentry.keys.EmpHrRolePK;


/**
 * Entity class mapping to table 'EMP_HR_ROLES'
 * 
 * @version 1.0.0 $ 2016-03-24 18:52 $
 */
@Entity
@Table( name = "EMP_HR_ROLES" )
public final class EmpHrRole implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    @EmbeddedId
    protected EmpHrRolePK empHrRolePK;
    
    
    public EmpHrRolePK getEmpHrRolePK() {
        return empHrRolePK;
    }
    
    public void setEmpHrRolePK( EmpHrRolePK empHrRolePK ) {
        this.empHrRolePK = empHrRolePK;
    }

    /*
     * Temprary implements hashCode by this method, might be problem there
     */
    @Override
    public int hashCode() {
        
        int hash = 0;
        hash += ( empHrRolePK != null ? empHrRolePK.hashCode() : 0 );
        
        return hash;
        
    }

    @Override
    public boolean equals( Object other ) {

        if ( other == null ) {
            return false;
        }
        
        if ( !( other instanceof EmpHrRole ) ) {
            return false;
        }
        
        EmpHrRole that = ( EmpHrRole ) other;
        return this.empHrRolePK.equals( that.getEmpHrRolePK() );
        
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.EmpHrRole[ empHrRolePK=" + empHrRolePK + " ]";
    }
    
    
} //:~
