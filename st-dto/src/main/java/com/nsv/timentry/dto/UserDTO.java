//: com.nsv.timentry.dto: UserDTO.java
package com.nsv.timentry.dto;

import java.io.Serializable;


/**
 * UserDTO connect present layer and service layer, mapped field for table 'USERS'
 *
 * @version 1.0.0 $ 2016-04-03 05:05 $
 */
public final class UserDTO implements Serializable {


    private static final long serialVersionUID = 4979242155377900278L;

    // ----------------------------------------------------------------------------------
    private final Short  id;
    private final Short  empId;
    private final String password;
    private final String name;
    private final String email;

    private final Short  managerId;
    private final Short  roleId;
    private final String roleType;
    private final Short  officeId;

    private UserDTO( Builder builder ) {
        this.id        = builder.id;
        this.password  = builder.password;
        this.managerId = builder.managerId;
        this.email     = builder.email;
        this.empId     = builder.empId;
        this.name      = builder.name;
        this.roleId    = builder.roleId;
        this.roleType  = builder.roleType;
        this.officeId  = builder.officeId;
    }

    public Short  managerId() { return this.managerId; }
    public Short  id()        { return this.id;        }
    public String password()  { return this.password;  }
    public String email()     { return this.email;     }
    public Short  empId()     { return this.empId;     }
    public String name()      { return this.name;      }
    public Short  roleId()    { return this.roleId;    }
    public String roleType()  { return this.roleType;  }
    public Short  officeId()  { return this.officeId;  }

    public Object[] asArrayInDBOrder() {
        return new Object[] {
                email, password, empId, roleId, managerId, officeId };
    }

    // ----------------------------------------------------------------------------------
    public static class Builder {

        private Short  id;
        private String email;
        private String password;
        private Short  empId;
        private String name;
        private String roleType;
        private Short  roleId;
        private Short  managerId;
        private Short  officeId;

        public Builder() {
            // Keep this as default
        }

        // Call private constructor to create DTO
        public UserDTO build() {
            return new UserDTO( this );
        }

        public Builder managerId( Short managerId ) {
            this.managerId = managerId;
            return this;
        }

        public Builder id( Short id ) {
            this.id = id;
            return this;
        }

        public Builder password( String password ) {
            this.password = password;
            return this;
        }

        public Builder email( String email ) {
            this.email = email;
            return this;
        }

        public Builder empId( Short empId ) {
            this.empId = empId;
            return this;
        }

        public Builder name( String name ) {
            this.name = name;
            return this;
        }

        public Builder roleType( String roleType ) {
            this.roleType = roleType;
            return this;
        }

        public Builder roleId( Short roleId ) {
            this.roleId = roleId;
            return this;
        }

        public Builder officeId( Short officeId ) {
            this.officeId = officeId;
            return this;
        }

    }
    // ----------------------------------------------------------------------------------


} //:~
