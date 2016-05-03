//: com.nsv.timentry.manager: EmployeeManagerLocal.java
package com.nsv.timentry.manager;

import java.util.Collection;

import javax.ejb.Local;
import com.nsv.timentry.entity.Employee;


/**
 * Employee manager bean local interface perform basic CRUD operation
 * 
 * @version 1.0.0 $ 2016-03-29 13:35 $
 */
@Local
public interface EmployeeManagerLocal extends GenericManagerLocal< Employee, Short > {

    Employee createBySQLThenGrab( String email, Object[] dbOrderedValues );
    Employee findByEmail( String email );

    Collection<Employee> queryByNameAndEmail( String name, String email, boolean isRemoved );
    
} //:~
