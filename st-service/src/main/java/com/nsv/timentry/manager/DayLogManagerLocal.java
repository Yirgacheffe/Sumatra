//: com.nsv.timentry.manager: DayLogManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.DayLog;


/**
 * DayLog manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 12:43 $
 */
@Local
public interface DayLogManagerLocal extends GenericManagerLocal< DayLog, Integer > {

    boolean createBySQL( Object[] dbOrderedParams );

} //:~
