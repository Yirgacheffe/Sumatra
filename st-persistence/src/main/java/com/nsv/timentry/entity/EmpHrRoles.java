//: com.nsv.timentry.entity: EmpHrRoles.java
package com.nsv.timentry.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nsv.timentry.keys.EmpHrRolesPK;


/**
 * Entity class mapping to table 'EMP_HR_ROLES'
 * 
 * @version 1.0.0 $ 2016-03-24 18:52 $
 */
@Entity
@Table( name = "EMP_HR_ROLES" )
public final class EmpHrRoles implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    @EmbeddedId
    protected EmpHrRolesPK empHrRolesPK;
    
    
    public void setEmpHrRolesPK(EmpHrRolesPK empHrRolesPK) {
        this.empHrRolesPK = empHrRolesPK;
    }

    public EmpHrRolesPK getEmpHrRolesPK() {
        return empHrRolesPK;
    }

    /*
     * Temprary implements hashCode by this method, might be problem there
     */
    @Override
    public int hashCode() {
        
        int hash = 0;
        hash += ( empHrRolesPK != null ? empHrRolesPK.hashCode() : 0 );
        
        return hash;
        
    }

    @Override
    public boolean equals( Object other ) {

        if ( other == null ) {
            return false;
        }
        
        if ( !( other instanceof EmpHrRoles ) ) {
            return false;
        }
        
        EmpHrRoles that = ( EmpHrRoles ) other;
        return this.empHrRolesPK.equals( that.getEmpHrRolesPK() );
        
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.EmpHrRoles[ empHrRolesPK=" + empHrRolesPK + " ]";
    }
    
    
} //:~
