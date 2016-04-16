//: com.nsv.timentry.manager: OfficeManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.Office;


/**
 * Office manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 13:09 $
 */
@Local
public interface OfficeManagerLocal extends GenericManagerLocal<Office, Short> {

    // Just keep this as default local interface...

} //:~
