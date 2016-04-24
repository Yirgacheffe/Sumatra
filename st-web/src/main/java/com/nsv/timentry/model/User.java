//: com.nsv.timentry.model: User.java
package com.nsv.timentry.model;

import java.io.Serializable;


/**
 * Model object only be used for struts framework
 *
 * @version 1.0.0 $ 2016-04-24 23:22 $
 */
public final class User implements Serializable {


    private static final long serialVersionUID = -2521378821778025612L;

    // ------------------------------------------------------------------------
    private Short  empId;
    private Short  id;
    // private String password;

    private String name;
    private String email;

    private Short  managerId;
    private Short  roleId;
    private String roleType;
    private Short  officeId;


    public User() {
        // ......
    }

    public User( Short  id, Short empId, String name, String email,
                 Short  managerId,
                 Short  roleId ,
                 String roleType, Short officeId ) {

        this.empId     = empId;
        this.email     = email;

        this.managerId = managerId;
        this.name      = name;
        this.id        = id;
        this.officeId  = officeId;
        this.roleId    = roleId;
        this.roleType  = roleType;
    }


    // ------------------------------------------------------------------------
    public Short getEmpId() {
        return empId;
    }

    public void setEmpId( Short empId ) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public Short getId() {
        return id;
    }

    public void setId( Short id ) {
        this.id = id;
    }

    public Short getManagerId() {
        return managerId;
    }

    public void setManagerId( Short managerId ) {
        this.managerId = managerId;
    }

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId( Short roleId ) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType( String roleType ) {
        this.roleType = roleType;
    }

    public Short getOfficeId() {
        return officeId;
    }

    public void setOfficeId( Short  officeId ) {
        this.officeId = officeId;
    }
    // ------------------------------------------------------------------------


} //:~
