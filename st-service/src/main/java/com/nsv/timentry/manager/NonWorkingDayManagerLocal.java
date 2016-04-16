package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.NonWorkingDay;

/**
 * NonWorkingDay manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 13:04 $
 */
@Local
public interface NonWorkingDayManagerLocal extends GenericManagerLocal< NonWorkingDay, Integer > {

    boolean createBySQL( Object[] dbOrderedParams );

} //:~
