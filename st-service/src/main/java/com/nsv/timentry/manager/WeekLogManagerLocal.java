//: com.nsv.timentry.manager: WeekLogManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.WeekLog;


/**
 * Certificate manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 13:15 $
 */
@Local
public interface WeekLogManagerLocal extends GenericManagerLocal<WeekLog, Integer> {

    boolean createBySQL( Object[] dbOrderedParams );

} //:~
