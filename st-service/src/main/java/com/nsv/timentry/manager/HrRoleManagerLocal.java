//: com.nsv.timentry.manager: HrRoleManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.HrRole;


/**
 * HrRole manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 12:57 $
 */
@Local
public interface HrRoleManagerLocal extends GenericManagerLocal< HrRole, Short > {

    // Just keep this as default generic interface...

} //:~
