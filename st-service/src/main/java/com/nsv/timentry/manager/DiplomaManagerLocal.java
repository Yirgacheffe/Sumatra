//: com.nsv.timentry.manager: DiplomaManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.Diploma;


/**
 * Certificate manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 12:47 $
 */
@Local
public interface DiplomaManagerLocal extends GenericManagerLocal<Diploma, Short> {

    // Just keep this as default generic interface...

} //:~
