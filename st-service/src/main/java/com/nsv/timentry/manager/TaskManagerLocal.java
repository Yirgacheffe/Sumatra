//: com.nsv.timentry.manager: TaskManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.Task;


/**
 * Certificate manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 13:13 $
 */
@Local
public interface TaskManagerLocal extends GenericManagerLocal<Task, Integer> {

    boolean createBySQL( Object[] dbOrderedParams );

} //:~
