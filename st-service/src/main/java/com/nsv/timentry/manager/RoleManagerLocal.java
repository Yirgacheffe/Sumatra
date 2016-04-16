//: com.nsv.timentry.manager: RoleManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.Role;


/**
 * Certificate manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 13:24 $
 */
@Local
public interface RoleManagerLocal extends GenericManagerLocal<Role, Short> {

    // Juts keep this as default local interface...

} //:~
