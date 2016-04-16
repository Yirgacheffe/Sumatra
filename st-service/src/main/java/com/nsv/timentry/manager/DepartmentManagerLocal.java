//: com.nsv.timentry.manager: DepartmentManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.Department;


/**
 * Department manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 12:44 $
 */
@Local
public interface DepartmentManagerLocal extends GenericManagerLocal<Department, Short> {

    // Just keep this as default generic interface...

} //:~