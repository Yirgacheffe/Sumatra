//: com.nsv.timentry.keys: EmpHrRolesPK.java
package com.nsv.timentry.keys;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;


/**
 * Primary key mapping table 'EMP_HR_ROLES'
 * 
 * @version 1.0.0 $ 2016-03-24 18:17 $
 */
@Embeddable
public final class EmpHrRolesPK implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private short empId;
    private short hrRoleId;
    
    
    public EmpHrRolesPK() {
        // Keep this default constructor...
    }
    
    public EmpHrRolesPK( short empId, short hrRoleId ) {
        this.empId    = empId;
        this.hrRoleId = hrRoleId;
    }

    
    @Column( name = "EMP_ID", nullable = false )
    @NotNull
    public short getEmpId() {
        return empId;
    }

    public void setEmpId( short empId ) {
        this.empId = empId;
    }

    @Column( name = "HR_ROLE_ID", nullable = false )
    @NotNull
    public short getHrRoleId() {
        return hrRoleId;
    }

    public void setHrRoleId( short hrRoleId ) {
        this.hrRoleId = hrRoleId;
    }

    
    /*
     * Temprary implements hashCode by using system method, might be problem there
     */
    @Override
    public int hashCode() {
        return System.identityHashCode( this );
    }
    

    @Override
    public boolean equals( Object other ) {
        
        if ( other == null ) {
            return false;
        }
        
        if ( !( other instanceof EmpHrRolesPK ) ) {
            return false;
        }
        
        EmpHrRolesPK that = ( EmpHrRolesPK ) other;
        return that.getEmpId() == empId && hrRoleId == that.getHrRoleId();
        
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.EmpHrRolesPK[ empId=" + empId + ", hrRoleId=" + hrRoleId + " ]";
    }
    
    
} //:~
